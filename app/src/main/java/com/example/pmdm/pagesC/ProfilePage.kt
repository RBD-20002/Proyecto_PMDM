package com.example.pmdm.pagesC

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.pmdm.R
import com.example.pmdm.components.DataProfileComponent
import com.example.pmdm.components.EditProfileDialog
import com.example.pmdm.components.FavColumnDisplay
import com.example.pmdm.components.PreviewFieldConfig
import com.example.pmdm.components.ProfileImagePickerSheet
import com.example.pmdm.components.TextComponent
import com.example.pmdm.navigation.Destination
import com.example.pmdm.ui.state.ProfilePageState
import com.example.pmdm.ui.theme.cardContainerColor

@Composable
fun ProfilePage(
    state: ProfilePageState,
    navController: NavController,
    onLogout: () -> Unit,
    onOpenImagePicker: () -> Unit,
    onCloseImagePicker: () -> Unit,
    presetImageIds: List<String>,
    imageUrlForId: (String) -> String,
    onSelectPreset: (String) -> Unit,

    onOpenEditDialog: () -> Unit,
    onCloseEditDialog: () -> Unit,
    onEditUsernameChange: (String) -> Unit,
    onEditEmailChange: (String) -> Unit,
    onSaveEdits: () -> Unit
) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(R.drawable.login_page),
            contentDescription = stringResource(R.string.Text_ProfilePage_1),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        if (!state.isLoggedIn) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                TextComponent(text = stringResource(R.string.Text_Error_Login), textSize = 24.sp)
                Spacer(modifier = Modifier.height(16.dp))
                TextComponent(text = stringResource(R.string.Text_Action_Login), textSize = 16.sp)
            }
            return
        }

        LazyColumn {
            item {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 26.dp, bottom = 26.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column (
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Card(
                            modifier = Modifier.size(160.dp),
                            shape = RoundedCornerShape(30.dp),
                            colors = CardDefaults.cardColors(containerColor = MaterialTheme.cardContainerColor),
                            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
                        ) {
                            Box(Modifier.fillMaxSize()) {
                                val model: Any? = when {
                                    state.profileImageUri != null -> state.profileImageUri
                                    state.profileImageId.isNotBlank() -> imageUrlForId(state.profileImageId)
                                    else -> null
                                }

                                if (model != null) {
                                    AsyncImage(
                                        model = model,
                                        contentDescription = stringResource(R.string.Text_ProfilePage_2),
                                        contentScale = ContentScale.Crop,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                } else {
                                    Image(
                                        painter = painterResource(id = R.drawable.logo),
                                        contentDescription = stringResource(R.string.Text_ProfilePage_3),
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(18.dp),
                                        contentScale = ContentScale.Fit
                                    )
                                }

                                if (state.isSavingImage) {
                                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        CircularProgressIndicator()
                                    }
                                }
                            }
                        }

                        IconButton(onClick = onOpenImagePicker) {
                            Icon(
                                imageVector = Icons.Default.Settings,
                                contentDescription = stringResource(R.string.Text_ProfilePage_4),
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(25.dp))

                    state.user?.let { user ->
                        val profileData = listOf(
                            PreviewFieldConfig(stringResource(R.string.Pag_Perfil_Text_2), user.username),
                            PreviewFieldConfig(stringResource(R.string.Pag_Perfil_Text_3), user.email)
                        )

                        Box {
                            DataProfileComponent(
                                title = stringResource(R.string.Pag_Perfil_Text_1),
                                items = profileData,
                                borderColor = Color.White
                            )

                            IconButton(
                                onClick = onOpenEditDialog,
                                modifier = Modifier
                                    .align(Alignment.TopEnd)
                                    .padding(10.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Settings,
                                    contentDescription = stringResource(R.string.Text_ProfilePage_5),
                                    tint = MaterialTheme.colorScheme.onBackground
                                )
                            }
                        }
                    }

                    state.infoMessage?.let { msg ->
                        Spacer(modifier = Modifier.height(10.dp))
                        TextComponent(
                            text = msg,
                            textColor = Color(0xFF66FF99), // verde suave
                            textSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    
                    Button(onClick = onLogout) {
                        Text(text = "Cerrar Sesión")
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    if (state.favorites.isNotEmpty()) {
                        FavColumnDisplay(favorites = state.favorites, navController = navController)
                    }

                    state.error?.let {
                        Spacer(modifier = Modifier.height(12.dp))
                        TextComponent(text = it, textColor = Color.Red)
                    }
                }
            }
        }

        if (state.isImagePickerOpen) {
            ProfileImagePickerSheet(
                presetImageIds = presetImageIds,
                imageUrlForId = imageUrlForId,
                onSelectPreset = onSelectPreset,
                onTakePhoto = {
                    onCloseImagePicker()
                    navController.navigate(Destination.Camera.route)
                },
                onDismiss = onCloseImagePicker
            )
        }

        if (state.isEditDialogOpen) {
            EditProfileDialog(
                username = state.editUsername,
                email = state.editEmail,
                isSaving = state.isSavingProfileData,
                error = state.editError,
                onUsernameChange = onEditUsernameChange,
                onEmailChange = onEditEmailChange,
                onSave = onSaveEdits,
                onCancel = onCloseEditDialog
            )
        }
    }
}
