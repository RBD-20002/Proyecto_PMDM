package com.example.pmdm.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.pmdm.model.Anime
import com.example.pmdm.ui.theme.cardContainerColor
import com.example.pmdm.ui.theme.cardTextColor
import com.example.pmdm.ui.theme.glassCardColor

@Composable
fun VerticalCard(
    anime: Anime,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(140.dp)
            .height(220.dp),
        onClick = { navController.navigate("details/${anime.id}") },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.cardContainerColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            AsyncImage(
                model = anime.imageUrl,
                contentDescription = anime.imageDesc,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .padding(top = 5.dp)
            )

            Text(
                text = anime.title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.cardTextColor,
                maxLines = 1,
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VerticalCardPreview() {
    val navController = rememberNavController()
    val sample = Anime(
        id = "dragon_ball",
        imageUrl = "https://placehold.co/300x400",
        imageDesc = "Goku",
        title = "DRAGON BALL Z",
        synopsis = "",
        info = ""
    )
    VerticalCard(anime = sample, navController = navController)
}
