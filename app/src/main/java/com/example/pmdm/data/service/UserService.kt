package com.example.pmdm.data.service

import com.example.pmdm.data.dto.ComplexSearchRequest
import com.example.pmdm.data.dto.CreateUserRequestDto
import com.example.pmdm.data.dto.CreateUserResponseDto
import com.example.pmdm.data.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Interfaz que define los servicios de API disponibles para operaciones relacionadas con usuarios.
 * Incluye funcionalidades para búsqueda, creación, actualización y gestión de usuarios.
 */
interface UserService {

    /**
     * Realiza una búsqueda simple de usuarios por un campo específico y su valor.
     *
     * @param folder Carpeta del recurso (por defecto: "users")
     * @param field Campo por el cual buscar (ej: "userName", "email", "id")
     * @param value Valor a buscar dentro del campo especificado
     * @return Lista de usuarios que coinciden con los criterios de búsqueda
     */
    @GET("json/{folder}/search")
    suspend fun searchUsers(
        @Path("folder") folder: String = "users",
        @Query("field") field: String,
        @Query("value") value: String
    ): List<UserDto>

    /**
     * Realiza una búsqueda compleja de usuarios con múltiples filtros y operadores.
     * Permite consultas avanzadas con combinaciones de condiciones.
     *
     * @param folder Carpeta del recurso (por defecto: "users")
     * @param request Objeto de búsqueda compleja que define múltiples filtros
     * @return Lista de usuarios que coinciden con todos los criterios de búsqueda
     */
    @POST("json/{folder}/complex-search")
    suspend fun complexSearchUsers(
        @Path("folder") folder: String = "users",
        @Body request: ComplexSearchRequest
    ): List<UserDto>

    /**
     * Crea un nuevo usuario en el sistema.
     *
     * @param folder Carpeta del recurso (por defecto: "users")
     * @param request Datos necesarios para crear el nuevo usuario
     * @return Respuesta que confirma la creación e incluye el ID asignado
     */
    @PUT("json/{folder}")
    suspend fun createUser(
        @Path("folder") folder: String = "users",
        @Body request: CreateUserRequestDto
    ): CreateUserResponseDto

    /**
     * Actualiza la información de un usuario existente.
     *
     * @param folder Carpeta del recurso (por defecto: "users")
     * @param id Identificador único del usuario a actualizar
     * @param user Objeto con los nuevos datos del usuario
     * @return Usuario actualizado con los cambios aplicados
     */
    @POST("json/{folder}/{id}")
    suspend fun updateUser(
        @Path("folder") folder: String = "users",
        @Path("id") id: String,
        @Body user: UserDto
    ): UserDto
}