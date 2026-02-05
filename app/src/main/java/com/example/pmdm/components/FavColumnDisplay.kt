package com.example.pmdm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.model.Anime
import com.example.pmdm.model.DataProvider

@Composable
fun FavColumnDisplay(
    favorites: List<Anime>,
    navController: NavController
) {
    val controller = navController
    val rows = favorites.chunked(2)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 12.dp, vertical = 6.dp)
        ) {
            TextComponent(
                text = stringResource(R.string.Pag_Favorito_Text_1),
                textSize = 30.sp,
                textColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        for (group in rows) {
            Row(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (anime in group) {
                    VerticalCard(anime = anime, navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FavColumnDisplayPreview() {
    val sampleFav = listOf(
        Anime("naruto", "naruto", "Naruto", "Naruto", "", ""),
        Anime("one_piece", "one_piece", "One Piece", "One Piece", "", "")
    )
    FavColumnDisplay(favorites = sampleFav, navController = rememberNavController())
}
