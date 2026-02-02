package com.example.pmdm.pagesC

import android.Manifest
import android.content.ContentValues

import android.net.Uri
import android.provider.MediaStore
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cameraswitch
import androidx.compose.material.icons.filled.PhotoCamera
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.navigation.NavController
import com.example.pmdm.R
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.rememberPermissionState

/**
 * Pantalla de cámara que gestiona permisos, selección de lente y captura de fotos.
 *
 * - Utiliza CameraX para mostrar la previsualización y capturar la imagen.
 * - Usa accompanist‑permissions para solicitar el permiso de cámara en tiempo de ejecución.
 * - Permite alternar entre la cámara trasera y delantera mediante un botón.
 * - Guarda la foto en el almacenamiento externo y devuelve el `Uri` capturado al volver.
 *
 * @param navController controlador de navegación para volver a la pantalla anterior.
 * @param onPhotoTaken callback que recibe el [Uri] de la foto capturada para guardarlo en el estado del perfil.
 */
@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun CameraPage(
    navController: NavController,
    onPhotoTaken: (Uri?) -> Unit
) {
    val context = LocalContext.current
    val cameraPermissionState: PermissionState = rememberPermissionState(Manifest.permission.CAMERA)
    val cameraSelectorState: MutableState<CameraSelector> = remember { mutableStateOf(CameraSelector.DEFAULT_BACK_CAMERA) }
    val imageCaptureState: MutableState<ImageCapture?> = remember { mutableStateOf(null) }
    val providerFuture = remember { ProcessCameraProvider.getInstance(context) }

    LaunchedEffect(Unit) {
        cameraPermissionState.launchPermissionRequest()
    }

    if (!cameraPermissionState.status.isGranted) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(R.string.Text_CameraPage_1))
            Button(onClick = { cameraPermissionState.launchPermissionRequest() }) {
                Text(text = stringResource(R.string.Text_CameraPage_2))
            }
        }
        return
    }

    val previewView = remember { PreviewView(context) }
    val lifecycleOwner = LocalLifecycleOwner.current
    LaunchedEffect(cameraSelectorState.value) {
        val cameraProvider: ProcessCameraProvider = providerFuture.get()
        val preview = androidx.camera.core.Preview.Builder().build().apply {
            surfaceProvider = previewView.surfaceProvider
        }
        val imageCapture = ImageCapture.Builder().build()
        imageCaptureState.value = imageCapture
        try {
            cameraProvider.unbindAll()
            cameraProvider.bindToLifecycle(
                 lifecycleOwner,
                cameraSelectorState.value,
                preview,
                imageCapture
            )
        } catch (exc: Exception) {
            exc.printStackTrace()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            { previewView },
            modifier = Modifier.fillMaxSize()
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = {
                cameraSelectorState.value = if (cameraSelectorState.value == CameraSelector.DEFAULT_BACK_CAMERA) {
                    CameraSelector.DEFAULT_FRONT_CAMERA
                } else {
                    CameraSelector.DEFAULT_BACK_CAMERA
                }
            }) {
                Icon(Icons.Default.Cameraswitch, contentDescription = stringResource(R.string.Text_CameraPage_3), tint = MaterialTheme.colorScheme.onBackground)
            }

            IconButton(onClick = {
                val imageCapture = imageCaptureState.value ?: return@IconButton
                val name = "IMG_${System.currentTimeMillis()}"
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, name)
                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, "Pictures/CameraX-Images")
                }
                val outputOptions = ImageCapture.OutputFileOptions.Builder(
                    context.contentResolver,
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                    contentValues
                ).build()

                imageCapture.takePicture(
                    outputOptions,
                    ContextCompat.getMainExecutor(context),
                    object : ImageCapture.OnImageSavedCallback {
                        override fun onImageSaved(outputFileResults: ImageCapture.OutputFileResults) {
                            val savedUri = outputFileResults.savedUri
                            // Llamar al callback con el Uri
                            onPhotoTaken(savedUri)
                            // Volver a la pantalla anterior
                            navController.popBackStack()
                        }

                        override fun onError(exception: ImageCaptureException) {
                            exception.printStackTrace()
                        }
                    }
                )
            }) {
                Icon(Icons.Default.PhotoCamera, contentDescription = stringResource(R.string.Text_CameraPage_4), tint = MaterialTheme.colorScheme.onBackground)
            }
        }
    }
}
