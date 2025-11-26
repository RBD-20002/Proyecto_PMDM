package com.example.pmdm.Components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.R

@Composable
fun LinkButtonComponent(img: Int, description: String, titleButton: String, action: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = action,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = img),
                    contentDescription = description,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextComponent(text = titleButton, textSize = 20.sp)
            }
        }
    }
}

@Preview
@Composable
fun previewLinkButton() {
    LinkButtonComponent(img = R.drawable.flv, description = "animeFLV", titleButton = "AnimeFLV") {
        Log.i("Prueba", "Click en el enlace de ANIMEFLV")
    }
}

@Preview
@Composable
fun preview2(){
    LinkButtonComponent(img = R.drawable.jk, description = "jkAime", titleButton = "JkAnime") {
        Log.i("Prueba", "Click en el enlace JKANIME")
    }
}