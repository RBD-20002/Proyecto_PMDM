package com.example.pmdm.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Componente personalizado de snackbar (notificación temporal) con estilo específico.
 * Proporciona un contenedor para mostrar mensajes breves al usuario con diseño personalizado.
 *
 * @param snackbarHostState Estado que controla la visualización y gestión de los snackbars
 * @param modifier Modificador opcional para personalizar el diseño del contenedor de snackbars
 */
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

/**
 * Vista previa que muestra el SnackbarComponent con un snackbar activo para visualización en el diseñador.
 * Simula un snackbar con un mensaje de ejemplo para verificar el diseño completo.
 */
@Preview(showBackground = true)
@Composable
fun SnackbarComponentActivePreview() {
    val snackbarHostState = remember { SnackbarHostState() }

    // Muestra un snackbar de ejemplo
    LaunchedEffect(Unit) {
        snackbarHostState.showSnackbar(
            message = "Ejemplo de mensaje de notificación",
            duration = SnackbarDuration.Long
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.BottomCenter
    ) {
        SnackbarComponent(
            snackbarHostState = snackbarHostState,
            modifier = Modifier.fillMaxWidth()
        )
    }
}