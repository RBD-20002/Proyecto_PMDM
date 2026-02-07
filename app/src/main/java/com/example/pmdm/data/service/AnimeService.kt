package com.example.pmdm.data.service

import com.example.pmdm.data.dto.AnimeDto
import com.example.pmdm.data.dto.ComplexSearchRequest
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interfaz que define los servicios de API disponibles para operaciones relacionadas con animes.
 * Utiliza Retrofit para realizar llamadas HTTP a un servidor backend.
 */
interface AnimeService {

    /**
     * Obtiene todos los animes disponibles utilizando una búsqueda compleja sin filtros.
     * Truco: buscar con "title contains ''" para obtener todos los registros.
     *
     * @param request Objeto de búsqueda compleja que define los filtros a aplicar
     * @return Lista completa de animes en formato DTO
     */
    @POST("json/anime/complex-search")
    suspend fun getAllAnimes(
        @Body request: ComplexSearchRequest
    ): List<AnimeDto>

    /**
     * Realiza una búsqueda simple de animes por un campo específico y su valor.
     *
     * @param field Campo por el cual buscar (por defecto: "title")
     * @param value Valor a buscar dentro del campo especificado
     * @return Lista de animes que coinciden con los criterios de búsqueda
     */
    @GET("json/anime/search")
    suspend fun searchAnimes(
        @Query("field") field: String = "title",
        @Query("value") value: String
    ): List<AnimeDto>

    /**
     * Realiza una búsqueda compleja con múltiples filtros y operadores.
     * Permite consultas más avanzadas que la búsqueda simple.
     *
     * @param request Objeto de búsqueda compleja que define múltiples filtros
     * @return Lista de animes que coinciden con todos los criterios de búsqueda
     */
    @POST("json/anime/complex-search")
    suspend fun complexSearch(@Body request: ComplexSearchRequest): List<AnimeDto>

    /**
     * Obtiene un anime específico por su identificador único.
     *
     * @param id Identificador único del anime a recuperar
     * @return Objeto AnimeDto con todos los datos del anime solicitado
     */
    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: String): AnimeDto
}