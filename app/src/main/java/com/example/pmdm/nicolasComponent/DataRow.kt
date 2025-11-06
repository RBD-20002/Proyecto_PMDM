package com.example.pmdm.nicolasComponent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.RicardoComponent.TextComponent

@Composable
fun PreviewDataRow(
    label: String,
    value: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextComponent(
            text = label,
            textSize = 15.sp,
            textColor = Color.White,
            modifier = Modifier.padding(3.dp)
        )
        TextComponent(
            text = value,
            textSize = 15.sp,
            textColor = Color.White
        )
    }
}

@Preview
@Composable
fun ejemplo() {
    PreviewDataRow("Usuario", "Paco")
}