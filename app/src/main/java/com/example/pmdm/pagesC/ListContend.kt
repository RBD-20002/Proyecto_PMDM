package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.components.BlockCardsComponents
import com.example.pmdm.R
import com.example.pmdm.state.StartPageState

@Composable
fun ListContend(
    navController: NavController,
    state: StartPageState
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_page),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.Crop
        )

        if (state.isLoading) {
            // Loading indicator
        } else if (state.error != null) {
            // Error message
        } else {
            BlockCardsComponents(
                input = state.animeList,
                navController = navController
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListContendPreview() {
    val sampleState = StartPageState(
        animeList = listOf(
            com.example.pmdm.model.CardConfig(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
            com.example.pmdm.model.CardConfig(2, R.drawable.onepiece, "One Piece", "One Piece", "", "")
        ),
        isLoading = false,
        error = null
    )

    ListContend(
        navController = rememberNavController(),
        state = sampleState
    )
}