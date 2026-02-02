package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pmdm.R
import com.example.pmdm.components.BlockDisplayCardComponent
import com.example.pmdm.components.SnackbarComponent
import com.example.pmdm.components.TextComponent
import com.example.pmdm.model.Anime
import com.example.pmdm.ui.state.DetailsPageState
import com.example.pmdm.ui.theme.cardTextColor
import kotlinx.coroutines.launch

@Composable
fun DetailsPage(
    state: DetailsPageState?,
    onToggleFavorite: () -> Unit,
    isUserLoggedIn: Boolean = false
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    if (state == null) return

    val titleColor = MaterialTheme.cardTextColor

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = stringResource(R.string.Text_DetailsPage_1),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { Spacer(modifier = Modifier.height(30.dp)) }

            item {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .border(
                                2.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(30.dp)
                            )
                            .clip(
                                RoundedCornerShape(30.dp)
                            )
                    ){
                        AsyncImage(
                            model = state.anime.imageUrl,
                            contentDescription = state.anime.imageDesc,
                            modifier = Modifier
                                .width(200.dp),
                            contentScale = ContentScale.FillWidth
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    TextComponent(
                        text = state.anime.title,
                        textSize = 30.sp,
                        textColor = Color.White,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            item {
                BlockDisplayCardComponent(animeInfo = state.anime)
            }

            item { Spacer(modifier = Modifier.height(80.dp)) }
        }

        if (isUserLoggedIn) {
            FloatingActionButton(
                onClick = {
                    onToggleFavorite()
                    scope.launch {
                        snackbarHostState.showSnackbar(
                            message = if (!state.isFavorite)
                                "${state.anime.title} añadido a favoritos"
                            else
                                "${state.anime.title} eliminado de favoritos",
                            duration = SnackbarDuration.Short
                        )
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = if (state.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = stringResource(R.string.Text_DetailsPage_2),
                    tint = if (state.isFavorite) Color.Red else Color.Gray
                )
            }
        }

        SnackbarComponent(
            snackbarHostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}

@Preview
@Composable
fun PreviewDetails() {
    val sampleState = DetailsPageState(
        anime = Anime(
            id = "naruto",
            imageUrl = "https://placehold.co/300x400",
            imageDesc = "Naruto Uzumaki",
            title = "DATE ASDAFSAF AFSFADSA DASSA",
            synopsis = "Naruto sigue a un joven ninja...",
            info = "Tipo: Serie...",
            enlace1 = "https://www3.animeflv.net/anime/naruto",
            enlace2 = "https://jkanime.net/naruto"
        ),
        isFavorite = true
    )
    DetailsPage(
        state = sampleState,
        onToggleFavorite = {},
        isUserLoggedIn = false
    )
}
