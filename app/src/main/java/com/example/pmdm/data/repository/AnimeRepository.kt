package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.AnimeDto
import com.example.pmdm.data.dto.ComplexSearchRequest
import com.example.pmdm.data.dto.SearchFilter
import com.example.pmdm.data.dto.SearchOperator
import com.example.pmdm.data.network.ApiConfig
import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.model.Anime

class AnimeRepository(
    private val animeService: AnimeService
) {

    private val favorites = mutableSetOf<String>()

    private var cachedAnimes: List<Anime> = emptyList()

    private fun AnimeDto.toDomain(): Anime {
        val base = "http://192.168.1.41:5131"  // o pásalo por config
        val url = imageId.takeIf { it.isNotBlank() }?.let { "$base/images/$it" }

        return Anime(
            id = id,
            imageUrl = "${ApiConfig.BASE_URL}images/$imageId",
            title = title,
            synopsis = synopsis,
            info = info,
            imageDesc = imageDesc,
            enlace1 = enlace1,
            enlace2 = enlace2,
            isPopular = false,
            isRecommended = false,
            isFavorite = favorites.contains(id)
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

        val dtos = animeService.getAllAnimes(req) // mismo endpoint complex-search
        val list = dtos.map { it.toDomain() }
        cachedAnimes = list
        return list
    }


    suspend fun getAnimeById(id: String): Anime {
        return animeService.getAnimeById(id).toDomain()
    }

    fun toggleFavorite(anime: Anime) {
        val key = anime.id.toString()
        if (favorites.contains(key)) {
            favorites.remove(key)
        } else {
            favorites.add(key)
        }
    }

    fun getFavorites(): List<Anime> {
        return cachedAnimes.filter { favorites.contains(it.id.toString()) }
    }
}
