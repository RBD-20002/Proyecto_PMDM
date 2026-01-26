package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pmdm.R
import com.example.pmdm.components.ButtomComponent
import com.example.pmdm.components.TextComponent
import com.example.pmdm.ui.state.LoginPageState

@Composable
fun LoginPage(
    state: LoginPageState,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onTogglePasswordVisibility: () -> Unit,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onGuestClick: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.login_page),
            contentDescription = "Fondo Login",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(90.dp)
                        .clip(RoundedCornerShape(40.dp))
                )
            }

            Spacer(modifier = Modifier.height(120.dp))

            TextComponent(
                text = "INICIAR SESIÓN",
                textSize = 20.sp,
                textColor = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextComponent(text = "EMAIL:", textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.email,
                onValueChange = onEmailChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextComponent(text = "PASSWORD:", textColor = Color.White, textSize = 13.sp)
            OutlinedTextField(
                value = state.password,
                onValueChange = onPasswordChange,
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = if (state.passwordVisible)
                    VisualTransformation.None
                else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = onTogglePasswordVisibility) {
                        Icon(
                            imageVector = if (state.passwordVisible)
                                Icons.Default.VisibilityOff
                            else
                                Icons.Default.Visibility,
                            contentDescription = "Toggle password visibility"
                        )
                    }
                }
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.TopEnd
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(5.dp),
                    modifier = Modifier.padding(10.dp)
                ) {
                    ButtomComponent(
                        text = "ENTRAR",
                        enabled = state.isLoginEnabled
                    ) {
                        onLoginClick()
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    ButtomComponent(
                        text = "CREAR CUENTA",
                        enabled = true
                    ) {
                        onRegisterClick()
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    ButtomComponent(
                        text = "ENTRAR COMO INVITADO",
                        enabled = true
                    ) {
                        onGuestClick()
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    state.loginError?.let { error ->
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
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
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPagePreview() {
    val sampleState = LoginPageState(
        email = "abc",
        password = "123",
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
