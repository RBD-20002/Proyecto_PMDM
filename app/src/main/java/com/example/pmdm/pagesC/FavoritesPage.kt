package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.FavColumnDisplay
import com.example.pmdm.components.TextComponent
import com.example.pmdm.R
import com.example.pmdm.model.Anime
import com.example.pmdm.ui.state.FavoritePageState

@Composable
fun FavoritePage(
    navController: NavController,
    state: FavoritePageState
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            item {
                if (state.isEmpty) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TextComponent(
                            text = "No hay favoritos",
                            textSize = 24.sp
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextComponent(
                            text = "Agrega animes a favoritos para verlos aquí",
                            textSize = 16.sp
                        )
                    }
                } else {
                    FavColumnDisplay(
                        favorites = state.favorites,
                        navController = navController
                    )
                }
            }

            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavoritePagePreview() {
    val sampleState = FavoritePageState(
        favorites = listOf(
            Anime(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
            Anime(2, R.drawable.one_piece, "One Piece", "One Piece", "", "")
        ),
        isEmpty = false
    )

    FavoritePage(
        navController = rememberNavController(),
        state = sampleState
    )
}