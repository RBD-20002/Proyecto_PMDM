package com.example.pmdm

import com.example.pmdm.model.Anime
import com.example.pmdm.model.CardConfig
import com.example.pmdm.model.DataProvider

// Funciones de conversión DIRECTAS (no object)
fun cardConfigToAnime(cardConfig: CardConfig, isFavorite: Boolean = false): Anime {
    return Anime(
        id = cardConfig.id,
        title = cardConfig.title,
        synopsis = cardConfig.synopsis,
        info = cardConfig.info,
        imageId = cardConfig.imageId,
        imageDesc = cardConfig.imageDesc,
        enlace1 = cardConfig.enlace1,
        enlace2 = cardConfig.enlace2,
        isFavorite = isFavorite
    )
}

fun animeToCardConfig(anime: Anime): CardConfig {
    return CardConfig(
        id = anime.id,
        imageId = anime.imageId,
        imageDesc = anime.imageDesc,
        title = anime.title,
        synopsis = anime.synopsis,
        info = anime.info,
        enlace1 = anime.enlace1,
        enlace2 = anime.enlace2,
        favorite = anime.isFavorite
    )
}

fun cardConfigListToAnimeList(cardConfigs: List<CardConfig>): List<Anime> {
    return cardConfigs.map { cardConfig ->
        cardConfigToAnime(cardConfig, DataProvider.isFavorite(cardConfig.id))
    }
}