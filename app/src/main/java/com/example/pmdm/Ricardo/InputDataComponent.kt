package com.example.pmdm.Ricardo

import TextFieldComponent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputDataComponent(
    text: String,
    state: TextFieldState,
    placeholder: (@Composable () -> Unit)? = null
){

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            TextComponent(
                text = text,
                textSize = 15.sp,
                textColor = Color.White,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1f)
            )

            TextFieldComponent(
                state = state,
                placeholder = placeholder,
                modifier = Modifier.width(900.dp)
            )
        }

}


@Preview
@Composable
fun previewInputBlock(){
    val state = remember { TextFieldState() }
    InputDataComponent(
        state = state,
        text = "USER:",
        placeholder = {
            TextComponent("USUARIO O CORREO ELECTRONICO", 15.sp, Color.LightGray)
        }
    )
}
