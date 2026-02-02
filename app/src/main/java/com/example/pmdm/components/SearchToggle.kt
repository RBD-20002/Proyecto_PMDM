package com.example.pmdm.components

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pmdm.R
import com.example.pmdm.ui.theme.neonTextGradientAlpha

@Composable
fun SearchToggle(
    modifier: Modifier = Modifier,
    hint: String = stringResource(R.string.Text_SearchToggle_1),
    results: List<String> = emptyList(),
    onSearch: (String) -> Unit = {},
    onResultClick: (String) -> Unit = {},
    externalActive: Boolean? = null,
    onActiveChangeExternal: ((Boolean) -> Unit)? = null,
    onQueryChangeExternal: ((String) -> Unit)? = null,
) {
    var internalActive by rememberSaveable { mutableStateOf(false) }
    var internalQuery by rememberSaveable { mutableStateOf("") }

    val active = externalActive ?: internalActive
    val setActive: (Boolean) -> Unit = onActiveChangeExternal ?: { internalActive = it }

    val query = internalQuery
    val setQuery: (String) -> Unit = { newQuery ->
        internalQuery = newQuery
        onQueryChangeExternal?.invoke(newQuery)
    }

    val configuration = LocalConfiguration.current
    val maxHeight = (configuration.screenHeightDp.dp * 0.5f)
    val baseHeight = 68.dp

    if (!active) return

    Card(
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
            .heightIn(min = baseHeight, max = maxHeight),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp)
                .then(Modifier)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(0.dp)
                    .then(Modifier)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(0.dp)
                        .then(Modifier)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(0.dp)
                .then(Modifier)
                .background(neonTextGradientAlpha(0.50f))
                .padding(12.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = { setQuery(it) },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                placeholder = { Text(hint, color = Color.White.copy(alpha = 0.85f)) },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = Color.White) },
                trailingIcon = {
                    IconButton(onClick = {
                        if (query.isNotEmpty()) setQuery("")
                        else setActive(false)
                    }) {
                        Icon(Icons.Default.Close, contentDescription = stringResource(R.string.Text_SearchToggle_2), tint = Color.White)
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color.White.copy(alpha = 0.7f),
                    unfocusedBorderColor = Color.White.copy(alpha = 0.5f),
                    cursorColor = Color.White
                )
            )

            if (results.isNotEmpty()) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 60.dp)
                        .heightIn(max = (maxHeight - baseHeight).coerceAtLeast(0.dp)),
                    contentPadding = PaddingValues(vertical = 6.dp)
                ) {
                    items(results) { r ->
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    onResultClick(r)
                                    setQuery(r)
                                    setActive(false)
                                }
                                .padding(horizontal = 10.dp, vertical = 12.dp)
                        ) {
                            Text(text = r, style = MaterialTheme.typography.bodyMedium, color = Color.White)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchTogglePreview() {
    MaterialTheme {
        Surface {
            SearchToggle(
                externalActive = true,
                results = listOf("Naruto", "Bleach", "One Piece"),
                onQueryChangeExternal = {},
                onResultClick = {}
            )
        }
    }
}
