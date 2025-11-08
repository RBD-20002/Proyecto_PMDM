package com.example.pmdm.nicolasComponent


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.RicardoComponent.TextComponent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed

data class PreviewFieldConfig(
    val label: String,
    val value: String
)


@Composable
fun DataProfileComponent(
    title: String = "DATOS USUARIO",
    items: List<PreviewFieldConfig>,
    borderColor: Color = Color.Black,
    backgroundColor: Color = Color(0xFF0A0D1F)
) {
    Column(
        modifier = Modifier
            .width(width = 300.dp)
            .border(5.dp, borderColor, RoundedCornerShape(10.dp))
            .padding(10.dp)
            .background(backgroundColor, RoundedCornerShape(10.dp)
                )
    ) {

            Box {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextComponent(
                        text = title,
                        textSize = 20.sp,
                        textColor = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp)
                    )
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items.forEach { item ->
                            PreviewDataRow(label = item.label, value = item.value)
                        }
                    }
                }
            }
        }

    }




@Preview
@Composable
fun DataPreviewComponentPreview() {
    val sampleItems = listOf(
        PreviewFieldConfig(label = "USER:",  value = "NicoDev"),
        PreviewFieldConfig(label = "EMAIL:", value = "nico@example.com"),
        PreviewFieldConfig(label = "PASS:",  value = "********"),
        PreviewFieldConfig(label = "ROLE:",  value = "Premium")
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        DataProfileComponent(
            title = "DATOS DE USUARIO",
            items = sampleItems,
            borderColor = Color.White
        )
    }
}
