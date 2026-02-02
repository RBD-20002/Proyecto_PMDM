package com.example.pmdm.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.pmdm.R
import com.example.pmdm.ui.theme.cardContainerColor

@Composable
fun EditProfileDialog(
    username: String,
    email: String,
    isSaving: Boolean,
    error: String?,
    onUsernameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onSave: () -> Unit,
    onCancel: () -> Unit
) {
    Dialog(onDismissRequest = onCancel) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.login_page),
                contentDescription = stringResource(R.string.Text_DataProfilePreview_1),
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.Crop
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.cardContainerColor)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Text(text = stringResource(R.string.Text_DataProfilePreview_2), style = MaterialTheme.typography.titleMedium)

                    OutlinedTextField(
                        value = username,
                        onValueChange = onUsernameChange,
                        label = { Text(stringResource(R.string.Text_DataProfilePreview_3)) },
                        singleLine = true,
                        enabled = !isSaving,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White
                        )
                    )

                    OutlinedTextField(
                        value = email,
                        onValueChange = onEmailChange,
                        label = { Text(stringResource(R.string.Text_DataProfilePreview_4)) },
                        singleLine = true,
                        enabled = !isSaving,
                        modifier = Modifier.fillMaxWidth(),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedTextColor = Color.White,
                            unfocusedTextColor = Color.White,
                            focusedBorderColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedLabelColor = Color.White,
                            unfocusedLabelColor = Color.White
                        )
                    )

                    error?.let { Text(text = it, color = Color.Red) }

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        ButtomComponent(
                            text = if (isSaving) stringResource(R.string.Text_DataProfilePreview_5) else stringResource(
                                R.string.Text_DataProfilePreview_6
                            ),
                            enabled = !isSaving
                        ) { onSave() }

                        ButtomComponent(
                            text = stringResource(R.string.Text_DataProfilePreview_7),
                            enabled = !isSaving
                        ) { onCancel() }
                    }
                }
            }
        }
    }
}
