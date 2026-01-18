package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.components.BlockInputsData
import com.example.pmdm.components.ButtomComponent
import com.example.pmdm.components.InputFieldConfig
import com.example.pmdm.components.TextFieldComponent
import com.example.pmdm.R
import com.example.pmdm.state.LoginPageState

@Composable
fun LoginPage(
    state: LoginPageState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGuestClick: () -> Unit,
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
                .padding(16.dp)
        ) {
            // Logo
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo Imagen Generico",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(40.dp))
                )
            }

            // Inputs
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                BlockInputsData(
                    title = "INICIAR SESIÓN",
                    input = listOf(
                        InputFieldConfig("EMAIL:", state.email),
                        InputFieldConfig(
                            "CONTRASEÑA:",
                            state.password,
                            placeholder = {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                                ) {
                                    TextFieldComponent(
                                        info = if (state.password.isEmpty()) "Introduce contraseña" else "•".repeat(
                                            state.password.length
                                        ),
                                        color = Color.Black
                                    )
                                    IconButton(onClick = onTogglePasswordVisibility) {
                                        Icon(
                                            imageVector = if (state.passwordVisible)
                                                Icons.Default.Visibility
                                            else
                                                Icons.Default.VisibilityOff,
                                            contentDescription = if (state.passwordVisible)
                                                "Ocultar contraseña"
                                            else
                                                "Mostrar contraseña"
                                        )
                                    }
                                }
                            }
                        )
                    ),
                    borderColor = Color.White
                )
            }

            // Botones
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.padding(10.dp)
                ) {
                    ButtomComponent(text = "CREAR CUENTA") { onRegisterClick() }
                    ButtomComponent(text = "INICIAR SESIÓN") { onLoginClick() }
                    ButtomComponent(text = "INVITADO") { onGuestClick() }
                }
            }

            // Error message
            state.loginError?.let { error ->
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    com.example.pmdm.components.TextComponent(
                        text = error,
                        textSize = 14.sp,
                        textColor = Color.Red
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    val sampleState = LoginPageState(
        email = "test@example.com",
        password = "123456",
        passwordVisible = false,
        isLoginEnabled = true,
        loginError = null
    )

    LoginPage(
        state = sampleState,
        onEmailChange = {},
        onPasswordChange = {},
        onTogglePasswordVisibility = {},
        onLoginClick = {},
        onRegisterClick = {},
        onGuestClick = {}
    )
}