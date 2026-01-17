package com.example.pmdm.components

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

/**
 * Componente de búsqueda interactiva con soporte para control interno o externo del estado.
 *
 * Este componente muestra una barra de búsqueda ([SearchBar]) con una lista desplegable de
 * resultados sugeridos. Puede funcionar de forma **autónoma** (controla internamente su
 * visibilidad y texto) o **controlada** por un estado externo (recibiendo callbacks de control).
 *
 * ### Características:
 * - Icono de búsqueda que activa la barra al presionarlo.
 * - Campo de texto con sugerencias dinámicas.
 * - Lista de resultados interactiva (permite seleccionar un elemento).
 * - Compatible con temas de Material 3.
 *
 * ### Modos de uso:
 * - **Modo interno**: el estado `active` y el texto se gestionan dentro del componente.
 * - **Modo externo**: el control del estado y del texto se delega al componente padre mediante:
 *   - [externalActive]
 *   - [onActiveChangeExternal]
 *   - [onQueryChangeExternal]
 *
 * @param modifier Modificador para ajustar tamaño y posición del componente.
 * @param hint Texto mostrado cuando el campo de búsqueda está vacío.
 * @param results Lista de resultados o sugerencias a mostrar debajo de la barra.
 * @param onSearch Acción ejecutada al confirmar la búsqueda (por ejemplo, presionar Enter).
 * @param onResultClick Acción ejecutada al seleccionar un resultado de la lista.
 * @param externalActive Estado opcional que define si la barra está activa (modo controlado).
 * @param onActiveChangeExternal Callback opcional para actualizar el estado de visibilidad desde fuera.
 * @param onQueryChangeExternal Callback opcional para notificar cambios en el texto desde fuera.
 */
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
    // Estado interno de visibilidad (si no está controlado externamente)
    var internalActive by rememberSaveable { mutableStateOf(false) }

    // Estado interno del texto de búsqueda
    var internalQuery by rememberSaveable { mutableStateOf("") }

    // Determina si el componente está usando control interno o externo
    val active = externalActive ?: internalActive
    val setActive: (Boolean) -> Unit = onActiveChangeExternal ?: { internalActive = it }

    val query = internalQuery
    val setQuery: (String) -> Unit = { newQuery ->
        internalQuery = newQuery
        onQueryChangeExternal?.invoke(newQuery)
    }

    Box(modifier = modifier.fillMaxWidth()) {
        // Si está inactivo, muestra sólo el icono de búsqueda
        if (!active) {
            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = { setActive(true) }
            ) {
                Icon(Icons.Default.Search, contentDescription = "Buscar")
            }
        }

        // Barra de búsqueda principal
        SearchBar(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth(),
            query = query,
            onQueryChange = { setQuery(it) },
            onSearch = {
                onSearch(query)
                // Si se desea mantener abierta la barra, se puede comentar esta línea
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
                }) {
                    Icon(Icons.Default.Close, contentDescription = "Cerrar búsqueda")
                }
            }
        ) {
            // Lista de resultados mostrada al escribir o buscar
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

/**
 * Vista previa del componente [SearchToggle].
 *
 * Muestra la barra de búsqueda con resultados de ejemplo
 * y un tema de Material 3 aplicado para pruebas visuales.
 */
@Preview(showBackground = true)
@Composable
private fun SearchTogglePreview() {
    MaterialTheme {
        Surface {
            SearchToggle(
                results = listOf("Naruto", "Bleach", "One Piece"),
                onSearch = { /* Ejemplo de búsqueda */ }
            )
        }
    }
}
