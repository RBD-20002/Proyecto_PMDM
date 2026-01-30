package com.example.pmdm.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.ui.theme.cardContainerColor
import com.example.pmdm.ui.theme.cardTextColor

@Composable
fun DisplayCardComponent(
    title: String,
    firstInfo: String,
    open: Boolean,
    onClick: () -> Unit,
    links: @Composable (() -> Unit)? = null,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        shape = MaterialTheme.shapes.extraLarge,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.cardContainerColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                TextComponent(
                    text = title,
                    textColor = MaterialTheme.cardTextColor,
                    textSize = 20.sp
                )

                Spacer(modifier = Modifier.weight(1f))

                Icon(
                    imageVector = if (open)
                        Icons.Default.KeyboardArrowUp
                    else
                        Icons.Default.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            AnimatedVisibility(open) {
                Column {
                    Spacer(modifier = Modifier.height(10.dp))
                    TextComponent(
                        text = firstInfo,
                        textSize = 15.sp,
                        textColor = MaterialTheme.cardTextColor
                    )
                    links?.invoke()
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "DisplayCard - Cerrado")
@Composable
fun DisplayCardComponentPreviewClosed() {
    MaterialTheme {
        DisplayCardComponent(
            title = "Título cerrado",
            firstInfo = "Este texto no debería verse",
            open = false,
            onClick = {}
        )
    }
}

@Preview(showBackground = true, name = "DisplayCard - Abierto")
@Composable
fun DisplayCardComponentPreviewOpen() {
    MaterialTheme {
        DisplayCardComponent(
            title = "Título abierto",
            firstInfo = "Texto visible cuando la card está abierta.",
            open = true,
            onClick = {},
            links = {
                Spacer(modifier = Modifier.height(8.dp))
                TextComponent(
                    text = "Link de ejemplo",
                    textSize = 14.sp,
                    textColor = MaterialTheme.cardTextColor
                )
            }
        )
    }
}
