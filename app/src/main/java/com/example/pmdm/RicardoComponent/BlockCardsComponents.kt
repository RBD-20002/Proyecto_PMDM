package com.example.pmdm.RicardoComponent

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R


@Composable
fun BlockCardsComponents(input: List<CardConfig>) {
    LazyColumn(modifier = Modifier.fillMaxWidth().border(2.dp, Color.Black),
        contentPadding = PaddingValues(5.dp)
    ){
        input.chunked(2).forEach { pares ->
            item {
                Row(modifier = Modifier
                    .fillMaxWidth()
                ){
                    pares.forEach { cardConfig ->
                        Column(modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                        ){
                            CardComponent(listOf(cardConfig))
                        }
                    }
                    if(pares.size == 1){
                        Spacer(modifier = Modifier
                            .weight(1f)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCards() {
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
        ),CardConfig(
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
        ),CardConfig(
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
    BlockCardsComponents(input = inputs)
}
