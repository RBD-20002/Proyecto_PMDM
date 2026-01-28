package com.example.pmdm.ui.theme

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
 * Esquema de colores para modo oscuro.
 */
private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Fondo_Oscuro
)

/**
 * Esquema de colores para modo claro.
 */
private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Fondo_Claro
)


val MaterialTheme.cardContainerColor: Color
    @Composable
    get() = if (MaterialTheme.colorScheme.background == Fondo_Oscuro) {
        CardDarkTransparent
    } else {
        CardLightTransparent
    }

val MaterialTheme.cardTextColor: Color
    @Composable
    get() = if (MaterialTheme.colorScheme.background == Fondo_Oscuro) {
        TextLight
    } else {
        TextDark
    }


/**
 * Gradiente de fondo adaptable al tema del sistema (claro u oscuro).
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
 * Gradiente horizontal tipo neón (texto/logo).
 */
val MaterialTheme.neonTextGradient: Brush
    @Composable
    get() = Brush.horizontalGradient(
        colors = listOf(
            Color(0xFFFF00E5),  // Rosa neón
            Color(0xFF00FFFF),  // Cian
            Color(0xFF0088FF)   // Azul eléctrico
        )
    )

/**
 * ✅ Color “glass” para cards/paneles: gris translúcido en oscuro,
 * blanco translúcido en claro.
 *
 * Úsalo así en tus Cards:
 *   containerColor = MaterialTheme.glassCardColor
 */
val MaterialTheme.glassCardColor: Color
    @Composable
    get() = if (isSystemInDarkTheme()) {
        GlassCardDark
    } else {
        GlassCardLight
    }

/**
 * Tema principal (Material 3).
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
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
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
