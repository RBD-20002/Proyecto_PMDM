package com.example.pmdm.Ricardo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    palabra: String,
    tamano: TextUnit = 25.sp,
    color: Color = Color.White
){
    Box(modifier = Modifier.padding(2.dp)){
        Text(text = palabra,
            fontSize = tamano,
            color = color
        )
    }
}

@Preview
@Composable
fun viewText(){
    TextComponent("USER:",10.sp)
}
