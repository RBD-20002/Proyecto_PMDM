package com.example.pmdm.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            .width(130.dp)
            .height(210.dp)
            .padding(end = 5.dp),
        onClick = { navController.navigate("details/${anime.id}") },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.cardContainerColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)
        ){
            Box(
                modifier = Modifier
                    .border(2.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(30.dp)
                    )
                    .clip(RoundedCornerShape(30.dp)
                    )
            ){
            AsyncImage(
                model = anime.imageUrl,
                contentDescription = anime.imageDesc,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
                    .border(2.dp,color = Color.White)
                    .clip(RoundedCornerShape(30.dp))
            )
                }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = anime.title,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.cardTextColor,
                maxLines = 1,
                fontSize = 10.sp
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
