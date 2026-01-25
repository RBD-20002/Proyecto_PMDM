package com.example.pmdm.data.repository

import com.example.pmdm.data.dto.AnimeDto
import com.example.pmdm.data.service.AnimeService
import com.example.pmdm.model.Anime

class AnimeRepository(
    private val animeService: AnimeService
) {

    private val favorites = mutableSetOf<String>()

    private var cachedAnimes: List<Anime> = emptyList()

    private fun AnimeDto.toDomain(): Anime {
        return Anime(
            id = id.toIntOrNull() ?: 0,
            imageId = imageId.toIntOrNull() ?: 0,
            title = title,
            synopsis = synopsis,
            info = info,
            imageDesc = imageDesc,
            enlace1 = enlace1,
            enlace2 = enlace2,
            isPopular = isPopular,
            isRecommended = isRecommended,
            isFavorite = favorites.contains(id)
        )
    }

    suspend fun getAnimeList(): List<Anime> {
        val dtos = animeService.getAnimeList()
        val list = dtos.map { it.toDomain() }
        cachedAnimes = list
        return list
    }

    suspend fun searchAnimes(query: String): List<Anime> {
        val dtos = animeService.searchAnimes(query)
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
