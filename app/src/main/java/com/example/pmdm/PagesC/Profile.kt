package com.example.pmdm.PagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import com.example.pmdm.RicardoComponent.BlockInputsData
import com.example.pmdm.RicardoComponent.InputFieldConfig
import com.example.pmdm.nicolasComponent.DataPreviewComponent
import com.example.pmdm.nicolasComponent.PreviewFieldConfig

@Composable
fun ProfilePage() {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_page),
            contentDescription = "Fondo de pantalla de Login",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            val previewItems = listOf(
                PreviewFieldConfig(label = "USER:", value = "NicoDev"),
                PreviewFieldConfig(label = "EMAIL:", value = "nico@example.com"),
                PreviewFieldConfig(label = "PASS:",  value = "********"),
                PreviewFieldConfig(label = "ROLE:",  value = "Premium")
            )


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                DataPreviewComponent(
                    title = "DATOS USUARIO",
                    items = previewItems,
                    borderColor = Color.White // o el que uses en tus otros bloques
                )
            }
        }
    }
}



@Preview
@Composable
fun ProfilePreview(){
    ProfilePage()
}