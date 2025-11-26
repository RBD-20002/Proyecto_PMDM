package com.example.pmdm.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Modelo de datos que define la configuración de un bloque de texto.
 *
 * Representa una sección de información con un título principal, un subtítulo opcional
 * y una descripción. Ideal para mostrar sinopsis, detalles o datos informativos.
 *
 * @property titleBlock Título del bloque (por ejemplo, "SINOPSIS" o "INFORMACIÓN").
 * @property title Subtítulo opcional que complementa al título principal.
 * @property descrip Texto descriptivo o informativo del bloque.
 * @property titleSize Tamaño de fuente usado en el título.
 * @property descripSize Tamaño de fuente usado en la descripción.
 */
data class TextBlockConfig(
    var titleBlock: String,
    var title: String = "",
    var descrip: String,
    var titleSize: TextUnit,
    var descripSize: TextUnit,
)

/**
 * Componente que muestra una lista de bloques de texto con formato estructurado.
 *
 * Cada bloque se representa dentro de un contenedor con borde redondeado,
 * fondo transparente y espaciado interno. Incluye un título y un texto
 * descriptivo, organizados en una disposición horizontal.
 *
 * ### Características:
 * - Usa un [Column] para apilar los bloques verticalmente.
 * - Cada bloque tiene un borde negro y esquinas redondeadas (40.dp).
 * - Separa el título y la descripción con una disposición [Row].
 * - Aplica espaciado uniforme entre bloques mediante [Spacer].
 *
 * @param info Lista de configuraciones [TextBlockConfig] que definen los bloques a renderizar.
 *
 * @see TextBlockConfig
 * @see TextComponent
 */
@Composable
fun TextBlockComponent(info: List<TextBlockConfig>) {
    Column() {
        info.forEach { inf ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(5.dp, Color.Black, RoundedCornerShape(40.dp))
                    .background(Color.Transparent)
            ) {
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(5.dp)
                            .weight(0.4f)
                    ) {
                        TextComponent(
                            text = inf.titleBlock+"\n" + inf.title,
                            textSize = inf.titleSize,
                            textColor = Color.White,
                            overflow = null,
                            maxLines = null
                        )
                    }
                    Box(
                        modifier = Modifier
                            .weight(0.6f)
                    ) {
                        TextComponent(text = inf.descrip, textSize = inf.descripSize)
                    }
                }
            }
            Spacer(modifier = Modifier.height(5.dp)
            )
        }
    }
}

/**
 * Vista previa del componente [TextBlockComponent].
 *
 * Muestra un ejemplo con dos bloques: uno para la sinopsis de *Naruto* y
 * otro para información técnica del anime.
 *
 * @see TextBlockComponent
 */

@Preview
@Composable
fun PreviewTextBlock() {
    var infos = listOf(
        TextBlockConfig(
            titleBlock = "SINOPSIS",
            title = "Naruto",
            descrip = "Naruto sigue a un joven ninja marginado, Naruto Uzumaki, que sueña con convertirse en Hokage, el líder de su aldea, para ganar reconocimiento. Lleva dentro al demonio Zorro de Nueve Colas, lo que lo hace temido por muchos. La historia muestra su crecimiento, sus amistades y sus batallas por proteger lo que ama.",
            titleSize = 20.sp,
            descripSize = 15.sp
        ),
        TextBlockConfig(
            titleBlock = "INFORMACION",
            descrip = "Tipo:\n" +
                    "Serie\n" +
                    "\nGeneros:\n" +
                    "Super Poderes, Shounen, Artes Marciales, Comedia, Accion\n" +
                    "\nStudios:\n" +
                    "Pierrot\n" +
                    "\nTemporada:\n" +
                    "Otoño 2002\n" +
                    "\nDemografia:\n" +
                    "Shounen\n" +
                    "\nIdiomas:\n" +
                    "Japonés\n" +
                    "\nEpisodios:\n" +
                    "220\n" +
                    "\nDuracion:\n" +
                    "23 min. por episodio\n" +
                    "\nEmitido:\n" +
                    "Jueves, 03 de Octubre de 2002",
            titleSize = 18.sp,
            descripSize = 15.sp
        )
    )

    TextBlockComponent(info = infos)
}