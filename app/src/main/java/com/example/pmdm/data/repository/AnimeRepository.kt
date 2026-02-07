package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.AnimeDto
import com.example.pmdm.data.dto.ComplexSearchRequest
import com.example.pmdm.data.dto.SearchFilter
import com.example.pmdm.data.dto.SearchOperator
import com.example.pmdm.data.network.ApiConfig
import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.data.service.UserService
import com.example.pmdm.model.Anime
import kotlinx.coroutines.flow.first

/**
 * Repositorio que gestiona las operaciones relacionadas con animes, incluyendo obtención, búsqueda,
 * y gestión de favoritos. Actúa como intermediario entre los servicios de red y el dominio de la aplicación.
 *
 * @property animeService Servicio para realizar llamadas a la API de animes
 * @property userRepository Repositorio para acceder a la información del usuario actual
 * @property userService Servicio para realizar llamadas a la API de usuarios
 */
class AnimeRepository(
    private val animeService: AnimeService,
    private val userRepository: UserRepository,
    private val userService: UserService
) {
    private var cachedAnimes: List<Anime> = emptyList()

    /**
     * Convierte un AnimeDto (formato de API) a un objeto Anime del dominio de la aplicación.
     * Construye la URL completa de la imagen y determina si el anime es favorito del usuario actual.
     *
     * @return Objeto Anime con todos los datos necesarios para la capa de presentación
     */
    private fun AnimeDto.toDomain(): Anime {
        val imageUrl = imageId
            .takeIf { it.isNotBlank() }
            ?.let { "${ApiConfig.BASE_URL}images/$it" }
            .orEmpty()

        val isFavorite = userRepository.session.value.user?.favoriteAnimes?.contains(id) ?: false

        return Anime(
            id = id,
            imageUrl = imageUrl,
            title = title,
            synopsis = synopsis,
            info = info,
            imageDesc = imageDesc,
            enlace1 = enlace1,
            enlace2 = enlace2,
            isPopular = false,
            isRecommended = false,
            isFavorite = isFavorite
        )
    }

    /**
     * Obtiene la lista completa de animes desde la API.
     * Realiza una búsqueda sin filtros para obtener todos los animes disponibles.
     *
     * @return Lista de objetos Anime del dominio de la aplicación
     */
    suspend fun getAnimeList(): List<Anime> {
        val req = ComplexSearchRequest(
            filters = listOf(
                SearchFilter(
                    field = "title",
                    operator = SearchOperator.Contains.code,
                    value = ""
                )
            )
        )

        val dtos = animeService.getAllAnimes(req)
        val list = dtos.map { it.toDomain() }
        cachedAnimes = list
        return list
    }

    /**
     * Realiza una búsqueda de animes por título utilizando el término de consulta proporcionado.
     *
     * @param query Término de búsqueda para filtrar animes por título
     * @return Lista de animes que coinciden con el término de búsqueda
     */
    suspend fun searchAnimes(query: String): List<Anime> {
        val req = ComplexSearchRequest(
            filters = listOf(
                SearchFilter(
                    field = "title",
                    operator = SearchOperator.Contains.code,
                    value = query
                )
            )
        )

        val dtos = animeService.getAllAnimes(req)
        val list = dtos.map { it.toDomain() }
        cachedAnimes = list
        return list
    }

    /**
     * Obtiene un anime específico por su identificador único.
     *
     * @param id Identificador único del anime a recuperar
     * @return Objeto Anime correspondiente al identificador proporcionado
     */
    suspend fun getAnimeById(id: String): Anime {
        return animeService.getAnimeById(id).toDomain()
    }

    /**
     * Alterna el estado de favorito de un anime para el usuario actual.
     * Si el anime ya es favorito, lo elimina; si no lo es, lo añade.
     * Actualiza tanto el servidor como el estado local de sesión.
     *
     * @param anime Anime cuyo estado de favorito se va a alternar
     */
    suspend fun toggleFavorite(anime: Anime) {
        val user = userRepository.session.first().user ?: return
        val currentFavorites = user.favoriteAnimes?.toMutableSet() ?: mutableSetOf()

        if (currentFavorites.contains(anime.id)) {
            currentFavorites.remove(anime.id)
        } else {
            currentFavorites.add(anime.id)
        }

        val updatedUser = user.copy(favoriteAnimes = currentFavorites.toList())
        userService.updateUser(id = user.id, user = updatedUser)
        userRepository.updateUserInSession(updatedUser)
    }

    /**
     * Verifica si un anime específico está marcado como favorito por el usuario actual.
     *
     * @param animeId Identificador único del anime a verificar
     * @return true si el anime es favorito, false en caso contrario
     */
    fun isFavorite(animeId: String): Boolean {
        return userRepository.session.value.user?.favoriteAnimes?.contains(animeId) ?: false
    }

    /**
     * Obtiene la lista de animes favoritos del usuario actual.
     * Filtra los animes en caché utilizando los identificadores de favoritos del usuario.
     *
     * @return Lista de animes marcados como favoritos por el usuario actual
     */
    fun getFavorites(): List<Anime> {
        val favoriteIds = userRepository.session.value.user?.favoriteAnimes ?: return emptyList()
        return cachedAnimes.filter { favoriteIds.contains(it.id) }
    }
}