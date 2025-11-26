package com.example.pmdm.Components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SnackbarComponent(
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
    ){
    SnackbarHost(
        hostState = snackbarHostState,
        modifier = modifier,
        snackbar = {snackbarData ->
            Snackbar(
                modifier = Modifier
                    .padding(5.dp)
                    .clip(shape = RoundedCornerShape(10.dp)),
                containerColor = Color.Gray,
                content = {
                    TextComponent(
                        text = snackbarData.visuals.message,
                        textSize = 8.sp
                    )
                }
            )
        }
    )
}