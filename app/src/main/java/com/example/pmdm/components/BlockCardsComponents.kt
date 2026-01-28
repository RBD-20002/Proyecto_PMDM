package com.example.pmdm.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.model.Anime

@Composable
fun BlockCardsComponents(
    input: List<Anime>,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalArrangement = Arrangement.Center
    ) {
        input.chunked(2).forEach { pares ->
            item {
                Row(modifier = Modifier.fillMaxWidth()) {
                    pares.forEach { cardConfig ->
                        Column(
                            modifier = Modifier
                                .weight(1f)
                                .padding(4.dp)
                        ) {
                            CardComponent(input = listOf(cardConfig), navController = navController)
                        }
                    }
                    if (pares.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlockCardsComponentsPreview() {
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
    BlockCardsComponents(input = listOf(sample, sample, sample), navController = navController)
}
