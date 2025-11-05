import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchToggle(
    modifier: Modifier = Modifier,
    hint: String = "Buscar...",
    results: List<String> = emptyList(),
    onSearch: (String) -> Unit = {},
    onResultClick: (String) -> Unit = {},
    externalActive: Boolean? = null,
    onActiveChangeExternal: ((Boolean) -> Unit)? = null,
    onQueryChangeExternal: ((String) -> Unit)? = null
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

    Box(modifier = modifier.fillMaxWidth()) {

        if (!active) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = { setActive(true) }
            ) {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
        }

        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            query = query,
            onQueryChange = { setQuery(it) },
            onSearch = {
                onSearch(query)
                // Si queremos que no se cierre comentamos lo de abajo
                setActive(false)
            },
            active = active,
            onActiveChange = { setActive(it) },
            placeholder = { Text(hint) },
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            trailingIcon = {
                IconButton(onClick = {
                    if (query.isNotEmpty()) {
                        setQuery("")
                    } else {
                        setActive(false)
                    }
                }) { Icon(Icons.Default.Close, null) }
            }
        ) {
            Column(Modifier.verticalScroll(rememberScrollState())) {
                results.forEach { r ->
                    ListItem(
                        headlineContent = { Text(r) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onResultClick(r)
                                setQuery(r)
                                setActive(false)
                            }
                    )
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
                results = listOf("Naruto", "Bleach", "One Piece"),
                onSearch = { /* TODO */ }
            )
        }
    }
}
