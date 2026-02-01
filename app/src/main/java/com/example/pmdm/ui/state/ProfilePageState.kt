package com.example.pmdm.ui.state

import android.net.Uri
import com.example.pmdm.model.Anime
import com.example.pmdm.model.User

data class ProfilePageState(
    val user: User? = null,
    val userId: String = "",
    val isLoggedIn: Boolean = false,
    val favorites: List<Anime> = emptyList(),

    val profileImageUri: Uri? = null,
    val profileImageId: String = "",

    val isImagePickerOpen: Boolean = false,
    val isSavingImage: Boolean = false,

    val isEditDialogOpen: Boolean = false,
    val editUsername: String = "",
    val editEmail: String = "",
    val isSavingProfileData: Boolean = false,
    val editError: String? = null,

    val infoMessage: String? = null,

    val error: String? = null
)
