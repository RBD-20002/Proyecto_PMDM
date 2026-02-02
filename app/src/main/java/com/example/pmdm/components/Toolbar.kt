package com.example.pmdm.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
 * Barra superior personalizada (Toolbar) con logotipo centrado e icono de búsqueda.
 *
 * Este componente utiliza un `CenterAlignedTopAppBar` de Material 3 para crear una barra superior
 * moderna y adaptativa, con un diseño consistente en temas claro y oscuro.
 *
 * ### Características:
 * - Logotipo centrado en la parte superior de la aplicación.
 * - Icono de búsqueda en el extremo izquierdo, con acción configurable.
 * - ✅ Icono de tema en el extremo derecho:
 *   - Sol si el sistema está en modo oscuro.
 *   - Luna si el sistema está en modo claro.
 * - Fondo con gradiente de color personalizado definido en [neonTextGradient].
 * - Compatible con el sistema de temas dinámicos de Compose.
 *
 * ### Uso típico:
 * Se utiliza como `topBar` dentro de un `Scaffold` junto con el componente [SearchToggle].
 *
 * @param onSearchClick Acción que se ejecuta al presionar el botón de búsqueda.
 * @param onThemeClick Acción opcional al presionar el icono de tema (por si luego quieres alternar tema manualmente).
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
 * Vista previa del componente [Toolbar] en **tema claro**.
 */
@Preview(showBackground = true, name = "Toolbar – Tema Claro")
@Composable
fun ToolbarPreviewLight() {
    PMDMTheme(darkTheme = false) {
        Toolbar(onSearchClick = {}, onThemeClick = {}, isDark = true)
    }
}

/**
 * Vista previa del componente [Toolbar] en **tema oscuro**.
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
