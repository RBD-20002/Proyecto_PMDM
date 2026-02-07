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
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import com.example.pmdm.ui.state.LoginPageState

/**
 * Pantalla de inicio de sesión que permite a los usuarios autenticarse en la aplicación.
 * Incluye campos para nombre de usuario y contraseña, opciones para recordar credenciales
 * y botones para iniciar sesión, registrarse o continuar como invitado.
 *
 * @param state Estado actual de la pantalla que contiene los valores de los campos y errores
 * @param authError Error de autenticación proveniente del ViewModel de autenticación
 * @param onUsernameChange Callback ejecutado cuando cambia el nombre de usuario
 * @param onPasswordChange Callback ejecutado cuando cambia la contraseña
 * @param onTogglePasswordVisibility Callback para alternar la visibilidad de la contraseña
 * @param onRememberCredentialsChange Callback para cambiar la opción de recordar credenciales
 * @param onLoginClick Callback ejecutado al hacer clic en el botón de iniciar sesión
 * @param onRegisterClick Callback ejecutado al hacer clic en el botón de registrarse
 * @param onGuestClick Callback ejecutado al hacer clic en el botón de continuar como invitado
 */
@Composable
fun LoginPage(
    state: LoginPageState,
    authError: String?,
    onUsernameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onRememberCredentialsChange: (Boolean) -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGuestClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_page),
            contentDescription = stringResource(R.string.Text_LoginPage_1),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = stringResource(R.string.Text_LoginPage_2),
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(40.dp))
                )
            }

            Spacer(modifier = Modifier.height(120.dp))

            TextComponent(
                text = stringResource(R.string.Pag_Inicio_Session_Text_1),
                textSize = 20.sp,
                textColor = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextComponent(text = stringResource(R.string.Pag_Inicio_Session_Text_2), textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.userName,
                onValueChange = onUsernameChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextComponent(text = stringResource(R.string.Pag_Inicio_Session_Text_3), textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.password,
                onValueChange = onPasswordChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedLabelColor = Color.White,
                    unfocusedLabelColor = Color.White,
                ),
                visualTransformation = if (state.passwordVisible) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    IconButton(onClick = onTogglePasswordVisibility) {
                        Icon(
                            imageVector = if (state.passwordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                            contentDescription = stringResource(R.string.Text_LoginPage_3)
                        )
                    }
                }
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = state.rememberCredentials,
                    onCheckedChange = onRememberCredentialsChange,
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.White,
                        uncheckedColor = Color.White,
                        checkmarkColor = Color.Black
                    )
                )
                TextComponent(text = "Recordar credenciales", textColor = Color.White, textSize = 13.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ButtomComponent(
                    text = stringResource(R.string.Pag_Inicio_Session_Text_4),
                    enabled = state.isLoginEnabled
                ) { onLoginClick() }

                ButtomComponent(
                    text = stringResource(R.string.Pag_Inicio_Session_Text_5),
                    enabled = true
                ) { onRegisterClick() }

                ButtomComponent(
                    text = stringResource(R.string.Pag_Inicio_Session_Text_6),
                    enabled = true
                ) { onGuestClick() }

                (authError ?: state.loginError)?.let { error ->
                    TextComponent(
                        text = error,
                        textColor = Color.Red,
                        textSize = 14.sp
                    )
                }
            }
        }
    }
}

/**
 * Vista previa del componente LoginPage para visualización en el diseñador de Android Studio.
 * Muestra la pantalla de inicio de sesión con datos de ejemplo y un error simulado.
 */
@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    val sampleState = LoginPageState(
        userName = "abc",
        password = "123",
        passwordVisible = false,
        isLoginEnabled = true,
        loginError = null
    )

    LoginPage(
        state = sampleState,
        authError = "Usuario o contraseña incorrectos",
        onUsernameChange = {},
        onPasswordChange = {},
        onTogglePasswordVisibility = {},
        onRememberCredentialsChange = {},
        onLoginClick = {},
        onRegisterClick = {},
        onGuestClick = {}
    )
}