package com.example.pmdm.ui.state

import android.net.Uri
import com.example.pmdm.model.Anime
import com.example.pmdm.model.User

/**
 * Estado de la pantalla de perfil.
 *
 * @property user datos del usuario actualmente autenticado.
 * @property isLoggedIn indica si el usuario ha iniciado sesión.
 * @property favorites lista de animes favoritos del usuario.
 * @property profileImageUri [Uri] de la foto de perfil tomada con la cámara, o null si
 *  no se ha capturado ninguna.
 */
data class ProfilePageState(
    val user: User? = null,
    val isLoggedIn: Boolean = false,
    val favorites: List<Anime> = emptyList(),
    val profileImageUri: Uri? = null
)
