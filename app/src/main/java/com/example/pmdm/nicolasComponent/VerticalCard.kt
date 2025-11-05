package com.example.pmdm.RicardoComponent

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R

@Composable
fun VerticalAnimeCard(
    cardConfig: CardConfig,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(140.dp)
            .height(220.dp),
        onClick = { navController.navigate("details/${cardConfig.id}") }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = cardConfig.imageId),
                contentDescription = cardConfig.imageDesc,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(170.dp)
            )
            Text(
                text = cardConfig.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                modifier = Modifier.padding(top = 6.dp, start = 8.dp, end = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun VerticalAnimeCardPreview() {
    val navController = rememberNavController()
    val sample = CardConfig(
        id = 1,
        imageId = R.drawable.dragonball,
        imageDesc = "Goku",
        title = "DRAGON BALL Z",
        synopsis = "",
        info = ""
    )
    VerticalAnimeCard(
        cardConfig = sample,
        navController = navController
    )
}
