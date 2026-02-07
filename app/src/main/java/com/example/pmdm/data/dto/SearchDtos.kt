package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

/**
 * Objeto de Transferencia de Datos (DTO) para realizar búsquedas complejas en la API.
 * Permite enviar múltiples filtros con diferentes condiciones de búsqueda.
 *
 * @property filters Lista de filtros de búsqueda a aplicar
 */
data class ComplexSearchRequest(
    @SerializedName("filters")
    val filters: List<SearchFilter>
)

/**
 * Representa un filtro individual para una búsqueda compleja.
 * Define un campo, un operador y un valor para aplicar como criterio de búsqueda.
 *
 * @property field Campo de la entidad sobre el cual aplicar el filtro
 * @property operator Código numérico que representa el operador de comparación
 * @property value Valor con el cual comparar el campo especificado
 */
data class SearchFilter(
    @SerializedName("field")
    val field: String,

    // IMPORTANTE: la API espera un número (0..4), no el nombre del enum
    @SerializedName("operator")
    val operator: Int,

    @SerializedName("value")
    val value: String
)

/**
 * Enumeración que define los operadores de búsqueda soportados por la API.
 * Cada operador tiene un código numérico que debe coincidir con lo esperado por el servidor.
 *
 * @property code Código numérico que representa el operador en la API:
 *                Equals=0, NotEquals=1, GreaterThan=2, LessThan=3, Contains=4
 */
enum class SearchOperator(val code: Int) {
    Equals(0),
    NotEquals(1),
    GreaterThan(2),
    LessThan(3),
    Contains(4)
}
