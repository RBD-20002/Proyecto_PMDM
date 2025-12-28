package com.example.pmdm.PagesC

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
import com.example.pmdm.Components.BlockCardsComponents
import com.example.pmdm.R
import com.example.pmdm.model.CardConfig
import com.example.pmdm.model.DataProvider

@Composable
fun ListContend(
    navController: NavController,
    animeList: List<CardConfig>
){
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.login_page),
            contentDescription = "Fondo",
            modifier = Modifier.fillMaxHeight(),
            contentScale = ContentScale.Crop
        )
        BlockCardsComponents(input = animeList, navController = navController)
    }
}

@Preview(showBackground = true)
@Composable
fun ListContendPreview() {
    val sample = listOf(
        CardConfig(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
        CardConfig(2, R.drawable.onepiece, "One Piece", "One Piece", "", "")
    )

    ListContend(
        navController = rememberNavController(),
        animeList = sample
    )
}
