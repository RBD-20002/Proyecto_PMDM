package com.example.pmdm.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import com.example.pmdm.ui.theme.PMDMTheme
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.res.stringResource
import com.example.pmdm.ui.theme.neonTextGradient

/**
 * Barra de herramientas personalizada con logo centrado, botón de búsqueda y botón de alternancia de tema.
 * Incluye un fondo con gradiente y gestiona la lógica de cambio entre temas claro/oscuro.
 *
 * @param isDark Estado booleano que indica si el tema actual es oscuro (true) o claro (false)
 * @param onSearchClick Función lambda que se ejecuta al hacer clic en el botón de búsqueda
 * @param onThemeClick Función lambda opcional que se ejecuta al hacer clic en el botón de alternancia de tema
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar(
    isDark: Boolean,
    onSearchClick: () -> Unit,
    onThemeClick: () -> Unit = {}
) {

    val logoRes = R.drawable.logo

    CenterAlignedTopAppBar(
        title = {
            Image(
                painter = painterResource(id = logoRes),
                contentDescription = stringResource(R.string.Text_Toolbar_1),
                modifier = Modifier.size(100.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = onSearchClick,
                modifier = Modifier.padding(top = 10.dp)) {
                Icon(
                    Icons.Default.Search,
                    contentDescription = stringResource(R.string.Text_Toolbar_2),
                    tint = MaterialTheme.colorScheme.background
                )
            }
        },
        actions = {
            IconButton(onClick = onThemeClick,
                modifier = Modifier.padding(top = 10.dp)) {
                Icon(
                    imageVector = if (isDark) Icons.Default.LightMode else Icons.Default.DarkMode,
                    contentDescription = if (isDark) stringResource(R.string.Text_Toolbar_3) else stringResource(
                        R.string.Text_Toolbar_4
                    ),
                    tint = MaterialTheme.colorScheme.background
                )
            }
        },
        // Fondo con gradiente personalizado y altura fija
        modifier = Modifier
            .background(MaterialTheme.neonTextGradient)
            .height(64.dp),
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Transparent
        )
    )
}

/**
 * Vista previa del componente Toolbar en modo de tema claro.
 * Muestra la barra de herramientas con configuración para tema claro.
 */
@Preview(showBackground = true, name = "Toolbar – Tema Claro")
@Composable
fun ToolbarPreviewLight() {
    PMDMTheme(darkTheme = false) {
        Toolbar(onSearchClick = {}, onThemeClick = {}, isDark = true)
    }
}

/**
 * Vista previa del componente Toolbar en modo de tema oscuro.
 * Muestra la barra de herramientas con configuración para tema oscuro.
 */
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Toolbar – Tema Oscuro"
)
@Composable
fun ToolbarPreviewDark() {
    PMDMTheme(darkTheme = true) {
        Toolbar(onSearchClick = {}, onThemeClick = {}, isDark = false)
    }
}