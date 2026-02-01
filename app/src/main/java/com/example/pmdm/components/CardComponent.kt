package com.example.pmdm.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.pmdm.model.Anime
import com.example.pmdm.navigation.Destination
import com.example.pmdm.ui.theme.cardContainerColor
import com.example.pmdm.ui.theme.cardTextColor

@Composable
fun CardComponent(input: List<Anime>, navController: NavController) {
    Column {
        input.forEach { cardConfig ->
            Card(
                modifier = Modifier
                    .width(220.dp)
                    .height(100.dp)
                    .padding(4.dp),
                onClick = { navController.navigate(Destination.Details.createRoute(cardConfig.id)) },
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.cardContainerColor
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
            ) {
                Row {
                    Box(
                        modifier = Modifier
                            .width(65.dp)
                            .fillMaxHeight()
                    ) {
                        AsyncImage(
                            model = cardConfig.imageUrl,
                            contentDescription = cardConfig.imageDesc,
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier.fillMaxSize()
                        )
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        Column {
                            TextComponent(
                                text = cardConfig.title,
                                textColor = MaterialTheme.cardTextColor,
                                textSize = 12.sp,
                                maxLines = 2
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardComponentPreview() {
    val navController = rememberNavController()
    val sample = Anime(
        id = "naruto",
        imageUrl = "https://placehold.co/300x400",
        imageDesc = "Naruto Uzumaki",
        title = "NARUTO",
        synopsis = "Naruto sigue a un joven ninja...",
        info = "Tipo: Serie\nGeneros: Shounen, Accion",
        enlace1 = "",
        enlace2 = ""
    )
    CardComponent(input = listOf(sample), navController = navController)
}
