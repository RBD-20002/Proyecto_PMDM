package com.example.pmdm.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

/**
 * Esquema de colores para el modo **oscuro** de la aplicación.
 *
 * Define los colores base usados en Material 3, incluyendo tonos primarios,
 * secundarios, de fondo y personalizados (como íconos o texto).
 */
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Fondo_Oscuro,
    primaryFixed = Icon,
    tertiaryFixed = TextColor
)

/**
 * Esquema de colores para el modo **claro** de la aplicación.
 *
 * Mantiene una estética limpia y colorida, con colores suaves de fondo
 * y tonos primarios inspirados en púrpuras y rosados.
 */
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Fondo_Claro,
    primaryFixed = Icon
)

/**
 * Gradiente de fondo adaptable al tema del sistema (claro u oscuro).
 *
 * Este gradiente se utiliza como fondo visual en pantallas o contenedores,
 * proporcionando profundidad y contraste visual.
 *
 * - En **modo oscuro**: tonos negros y azulados sutiles.
 * - En **modo claro**: mezcla vertical de rosado, azul y crema.
 */
val MaterialTheme.backgroundGradient: Brush
    @Composable
    get() = if (isSystemInDarkTheme()) {
        Brush.verticalGradient(
            colors = listOf(
                Color(0xFF000000),  // Negro puro
                Color(0xFF0F1419)   // Gris azulado oscuro
            )
        )
    } else {
        Brush.verticalGradient(
            0.0f to Color(0xFFFFF4F8), // Rosa pálido (inicio)
            0.5f to Color(0xFFB3E5FC), // Azul medio (centro)
            1.0f to Color(0xFFFDFDF5)  // Crema claro (final)
        )
    }

/**
 * Gradiente horizontal con efecto **neón**, inspirado en el texto del logotipo.
 *
 * Se utiliza para destacar elementos como títulos, barras o fondos decorativos
 * que requieran un aspecto brillante y moderno.
 *
 * Colores:
 * - Rosa neón → Cian → Azul eléctrico.
 */
val MaterialTheme.neonTextGradient: Brush
    @Composable
    get() = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFF00E5),  // Rosa neón (inicio)
            Color(0xFF00FFFF),  // Cian (medio)
            Color(0xFF0088FF)   // Azul neón (final)
        )
    )

/**
 * Tema principal de la aplicación **PMDM**, basado en Material 3.
 *
 * Gestiona automáticamente el esquema de colores según el modo del sistema
 * (oscuro o claro) y permite activar el modo dinámico en Android 12+.
 *
 * ### Características:
 * - Usa los esquemas [LightColorScheme] y [DarkColorScheme].
 * - Compatible con colores dinámicos (`dynamicColor = true`).
 * - Aplica la tipografía definida en [Typography].
 *
 * @param darkTheme Si `true`, aplica el esquema oscuro (por defecto usa el tema del sistema).
 * @param dynamicColor Si `true`, habilita colores dinámicos en Android 12 o superior.
 * @param content Contenido composable al que se aplicará el tema.
 */
@Composable
fun PMDMTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context)
            else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
