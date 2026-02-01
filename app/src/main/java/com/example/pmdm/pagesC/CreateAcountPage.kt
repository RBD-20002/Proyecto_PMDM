package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.R
import com.example.pmdm.components.ButtomComponent
import com.example.pmdm.components.TextComponent
import com.example.pmdm.ui.state.CreateAccountPageState

@Composable
fun CreateAcountPage(
    state: CreateAccountPageState,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onRepeatPasswordChange: (String) -> Unit,
    onCreateClick: () -> Unit,
    onCancelClick: () -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onToggleRepeatPasswordVisibility: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_page),
            contentDescription = "Fondo de pantalla de Login",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Imagen Generico",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(40.dp))
                )
            }

            Spacer(modifier = Modifier.height(14.dp))

            TextComponent(
                text = stringResource(R.string.PCA_Text_1),
                textSize = 20.sp,
                textColor = Color.White
            )

            Spacer(modifier = Modifier.height(14.dp))

            TextComponent(text = stringResource(R.string.PCA_Text_2), textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.username,
                onValueChange = onUsernameChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextComponent(text = stringResource(R.string.PCA_Text_3), textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.email,
                onValueChange = onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextComponent(text = stringResource(R.string.PCA_Text_4), textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.password,
                onValueChange = onPasswordChange,
                visualTransformation = if (state.passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (state.passwordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    val desc = if (state.passwordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                    IconButton(onClick = onTogglePasswordVisibility) {
                        Icon(imageVector = icon, contentDescription = desc)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextComponent(text = stringResource(R.string.PCA_Text_5), textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.repeatPassword,
                onValueChange = onRepeatPasswordChange,
                visualTransformation = if (state.repeatPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (state.repeatPasswordVisible) Icons.Filled.VisibilityOff else Icons.Filled.Visibility
                    val desc = if (state.repeatPasswordVisible) "Ocultar contraseña" else "Mostrar contraseña"
                    IconButton(onClick = onToggleRepeatPasswordVisibility) {
                        Icon(imageVector = icon, contentDescription = desc)
                    }
                },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.padding(10.dp)
                ) {
                    ButtomComponent(text = stringResource(R.string.PCA_Text_6)) { onCreateClick() }
                    ButtomComponent(text = stringResource(R.string.PCA_Text_7)) { onCancelClick() }
                }
            }

            state.error?.let {
                TextComponent(
                    text = it,
                    textColor = Color.Red
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CreateAcountPagePreview() {
    val exampleState = CreateAccountPageState(
        username = "usuario123",
        email = "ejemplo@email.com",
        password = "Contraseña",
        repeatPassword = "Contraseña",
        error = null
    )

    MaterialTheme {
        CreateAcountPage(
            state = exampleState,
            onUsernameChange = { },
            onEmailChange = { },
            onPasswordChange = { },
            onRepeatPasswordChange = { },
            onCreateClick = { },
            onCancelClick = { },
            onTogglePasswordVisibility = { },
            onToggleRepeatPasswordVisibility = { }
        )
    }
}
