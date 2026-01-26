package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

data class ComplexSearchRequest(
    @SerializedName("filters")
    val filters: List<SearchFilter>
)

data class SearchFilter(
    val field: String,
    val operator: SearchOperator,
    val value: String
)

// Debe coincidir con los números de la API:
// Equals=0, NotEquals=1, GreaterThan=2, LessThan=3, Contains=4
enum class SearchOperator(val code: Int) {
    Equals(0),
    NotEquals(1),
    GreaterThan(2),
    LessThan(3),
    Contains(4)
}