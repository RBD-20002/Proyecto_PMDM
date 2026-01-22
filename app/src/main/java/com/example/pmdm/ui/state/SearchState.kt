package com.example.pmdm.ui.state

data class SearchState(
    val query: String = "",
    val results: List<String> = emptyList(),
    val isActive: Boolean = false
)
