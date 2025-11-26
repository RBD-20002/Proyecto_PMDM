package com.example.pmdm.PagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pmdm.R
import com.example.pmdm.model.DataProvider
import com.example.pmdm.Components.FavColumnDisplay


@Composable
fun FavoritePage() {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            FavColumnDisplay(
                title = "Tus Favoritos",
                favorites = DataProvider.animeList.take(15) //TODO: cambiar a los favoritos cuando se sepamos como
            )
        }

    }
}


@Preview
@Composable
fun FavoritePreview() {
    FavoritePage()
}