package com.example.pmdm.PagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.pmdm.R
import com.example.pmdm.RicardoComponent.BlockCardsComponents
import com.example.pmdm.RicardoComponent.CardConfig
import com.example.pmdm.nicolas.Toolbar

@Composable
fun ListContend() {

    val inputs = listOf(
        CardConfig(
            ImageId = R.drawable.bleach,
            ImageDesc = "Imagen Bleach",
            Title = "BLEACH"
        ),
        CardConfig(
            ImageId = R.drawable.naruto,
            ImageDesc = "Imagen Naruto",
            Title = "NARUTO"
        ),
        CardConfig(
            ImageId = R.drawable.dragonball,
            ImageDesc = "Imagen Dragon Ball Z",
            Title = "DRAGON BALL Z"
        ),
        CardConfig(
            ImageId = R.drawable.onepiece,
            ImageDesc = "Imagen One Piece",
            Title = "ONE PIECE"
        ), CardConfig(
            ImageId = R.drawable.bleach,
            ImageDesc = "Imagen Bleach",
            Title = "BLEACH"
        ),
        CardConfig(
            ImageId = R.drawable.naruto,
            ImageDesc = "Imagen Naruto",
            Title = "NARUTO"
        ),
        CardConfig(
            ImageId = R.drawable.dragonball,
            ImageDesc = "Imagen Dragon Ball Z",
            Title = "DRAGON BALL Z"
        ),
        CardConfig(
            ImageId = R.drawable.onepiece,
            ImageDesc = "Imagen One Piece",
            Title = "ONE PIECE"
        ), CardConfig(
            ImageId = R.drawable.bleach,
            ImageDesc = "Imagen Bleach",
            Title = "BLEACH"
        ),
        CardConfig(
            ImageId = R.drawable.naruto,
            ImageDesc = "Imagen Naruto",
            Title = "NARUTO"
        ),
        CardConfig(
            ImageId = R.drawable.dragonball,
            ImageDesc = "Imagen Dragon Ball Z",
            Title = "DRAGON BALL Z"
        ),
        CardConfig(
            ImageId = R.drawable.onepiece,
            ImageDesc = "Imagen One Piece",
            Title = "ONE PIECE"
        )
    )
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        contentWindowInsets = WindowInsets.safeDrawing, // respeta zonas seguras
        topBar = { Toolbar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.list_content),
                contentDescription = "Fondo",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            BlockCardsComponents(input = inputs)
        }
    }

}

@Preview
@Composable
fun PreviewList() {
    ListContend()
}