package com.example.pmdm.Ricardo

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class InputFieldConfig(
    val text: String,
    val state: TextFieldState,
    val textPlaceholder: String
)

@Composable
fun BlockInputsData(
    title: String = "REGISTRATE",
    input: List<InputFieldConfig>,
    modifier: Modifier = Modifier,
    borderColor: Color = Color.Black
){
    Box(modifier = Modifier
        .border(
            width = 5.dp,
            color = borderColor,
            shape = RoundedCornerShape(10.dp)
        )
        .padding(10.dp)
        .background(Color(0xFFD77A28))
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            TextComponent(
                text = title,
                textSize = 20.sp,
                textColor = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )
            Column(
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                input.forEach { input ->
                    InputDataComponent(
                        text = input.text,
                        state = input.state,
                        placeholder = {
                            TextComponent(
                                text = input.textPlaceholder,
                            )
                        }
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PreviewInputsComponent() {
    val inputs = listOf(
        InputFieldConfig(
            text = "USER:",
            state = remember { TextFieldState() },
            textPlaceholder = "INTRODUCE TU USUARIO"
        ),
        InputFieldConfig(
            text = "EMAIL:",
            state = remember { TextFieldState() },
            textPlaceholder = "INTRODUCE EMAIL"
        ),
        InputFieldConfig(
            text = "PASSWORD:",
            state = remember { TextFieldState() },
            textPlaceholder = "INTRODUCE PASSWORD"
        ),
        InputFieldConfig(
            text = "CONFIRM:",
            state = remember { TextFieldState() },
            textPlaceholder = "REPITE PASSWORD"
        )
    )
    BlockInputsData(input = inputs)
}
