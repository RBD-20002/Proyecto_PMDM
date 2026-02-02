package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.BlockCardsComponents
import com.example.pmdm.R
import com.example.pmdm.components.TextComponent
import com.example.pmdm.model.Anime
import com.example.pmdm.ui.state.StartPageState

@Composable
fun ListContend(
    navController: NavController,
    state: StartPageState
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_page),
            contentDescription = stringResource(R.string.Text_ListConted_1),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    TextComponent(text = stringResource(R.string.Text_ListContend_2), textSize = 20.sp)
                }
            }

            state.error != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 140.dp),
                    contentAlignment = Alignment.Center
                ) {
                    TextComponent(
                        text = "Error: ${state.error}",
                        textColor = Color.Red,
                        textSize = 16.sp
                    )
                }
            }

            else -> {
                BlockCardsComponents(
                    input = state.animeList,
                    navController = navController
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListContendPreview() {
    val sampleState = StartPageState(
        animeList = listOf(
            Anime("naruto", "naruto","Naruto", "Naruto", "", ""),
            Anime("one_piece", "one_piece", "One Piece", "One Piece", "", "")
        ),
        isLoading = false,
        error = null
    )

    ListContend(
        navController = rememberNavController(),
        state = sampleState,
    )
}