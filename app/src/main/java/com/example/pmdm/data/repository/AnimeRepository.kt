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

class AnimeRepository(
    private val animeService: AnimeService,
    private val userRepository: UserRepository,
    private val userService: UserService
) {

    private var cachedAnimes: List<Anime> = emptyList()

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

    suspend fun getAnimeById(id: String): Anime {
        return animeService.getAnimeById(id).toDomain()
    }

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

    fun isFavorite(animeId: String): Boolean {
        return userRepository.session.value.user?.favoriteAnimes?.contains(animeId) ?: false
    }

    fun getFavorites(): List<Anime> {
        val favoriteIds = userRepository.session.value.user?.favoriteAnimes ?: return emptyList()
        return cachedAnimes.filter { favoriteIds.contains(it.id) }
    }
}
