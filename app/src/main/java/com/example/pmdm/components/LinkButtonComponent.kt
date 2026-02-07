package com.example.pmdm.components

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

/**
 * Componente de botón con icono personalizado diseñado específicamente para enlaces externos.
 * Combina una imagen, texto descriptivo y acción de clic en un diseño horizontal.
 *
 * @param img ID del recurso drawable que se muestra como icono junto al texto
 * @param description Texto de accesibilidad que describe la imagen para lectores de pantalla
 * @param titleButton Texto que se muestra como etiqueta del botón
 * @param action Función lambda que se ejecuta cuando se hace clic en el botón
 */
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

/**
 * Vista previa del componente LinkButtonComponent con icono de AnimeFLV.
 * Muestra cómo se vería un botón para enlazar al sitio de AnimeFLV.
 */
@Preview
@Composable
fun previewLinkButton() {
    LinkButtonComponent(img = R.drawable.flv, description = "animeFLV", titleButton = "AnimeFLV") {
        Log.i("Prueba", "Click en el enlace de ANIMEFLV")
    }
}

/**
 * Vista previa alternativa del componente LinkButtonComponent con icono de JKAnime.
 * Muestra cómo se vería un botón para enlazar al sitio de JKAnime.
 */
@Preview
@Composable
fun preview2(){
    LinkButtonComponent(img = R.drawable.jk, description = "jkAime", titleButton = "JkAnime") {
        Log.i("Prueba", "Click en el enlace JKANIME")
    }
}