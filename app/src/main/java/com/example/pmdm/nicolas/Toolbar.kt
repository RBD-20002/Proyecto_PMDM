package com.example.pmdm.nicolas
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    CenterAlignedTopAppBar(
        title = { Text("Mi toolbar") },
        actions = {
            IconButton(
                onClick = { Log.e("Msg", "Botón de ajustes") },
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFFF9000))
            ) {
                Icon(Icons.Default.Person, contentDescription = "Ajustes")
            }
        }
    )
}

@Preview
@Composable
fun PruebaVista() {
    Toolbar()
}

