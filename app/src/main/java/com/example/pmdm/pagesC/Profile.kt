package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.pmdm.R
import com.example.pmdm.components.DataProfileComponent
import com.example.pmdm.components.FavColumnDisplay
import com.example.pmdm.components.PreviewFieldConfig
import com.example.pmdm.components.ProfileCard
import com.example.pmdm.components.TextComponent
import com.example.pmdm.model.Anime
import com.example.pmdm.model.User
import com.example.pmdm.navigation.Destination
import com.example.pmdm.ui.state.ProfilePageState

/**
 * Pantalla del perfil de usuario.  Muestra un mensaje si no está logueado,
 * y en caso contrario muestra la tarjeta de perfil, los datos y la lista de favoritos.
 */
@Composable
fun ProfilePage(
    state: ProfilePageState,
    navController: NavController
) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        if (!state.isLoggedIn) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextComponent(text = "No has iniciado sesión", textSize = 24.sp)
                Spacer(modifier = Modifier.height(16.dp))
                TextComponent(text = "Inicia sesión para ver tu perfil", textSize = 16.sp)
            }
        } else {
            state.user?.let { user ->
                LazyColumn {
                    item {
                        Column(
                            modifier = Modifier.fillMaxSize().padding(top = 26.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            // Tarjeta de perfil con foto capturada o imagen por defecto
                            ProfileCard(
                                anime = Anime(
                                    id = 1,
                                    imageId = R.drawable.crocs,
                                    imageDesc = "crocs",
                                    title = user.username,
                                    synopsis = "",
                                    info = ""
                                ),
                                profileImageUri = state.profileImageUri,
                                onCameraClick = {
                                    navController.navigate(Destination.Camera.route)
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            val profileData = listOf(
                                PreviewFieldConfig("USUARIO:", user.username),
                                PreviewFieldConfig("EMAIL:", user.email),
                                PreviewFieldConfig("ROL:", "Premium")
                            )
                            DataProfileComponent(
                                title = "DATOS USUARIO",
                                items = profileData,
                                borderColor = Color.White
                            )
                            Spacer(modifier = Modifier.height(24.dp))
                            if (state.favorites.isNotEmpty()) {
                                FavColumnDisplay(favorites = state.favorites, navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePreview() {
    val sampleState = ProfilePageState(
        user = User("NicoDev", "nico@example.com"),
        isLoggedIn = true,
        favorites = listOf(
            Anime(1, R.drawable.naruto, "Naruto", "Naruto", "", ""),
            Anime(2, R.drawable.onepiece, "One Piece", "One Piece", "", "")
        ),
        profileImageUri = null
    )
    ProfilePage(state = sampleState, navController = rememberNavController())
}
