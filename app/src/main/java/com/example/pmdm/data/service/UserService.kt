package com.example.pmdm.data.service

import com.example.pmdm.data.dto.ComplexSearchRequest
import com.example.pmdm.data.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface UserService {

    @GET("json/{folder}/search")
    suspend fun searchUsers(
        @Path("folder") folder: String = "users",
        @Query("field") field: String,
        @Query("value") value: String
    ): List<UserDto>

    @POST("json/{folder}/complex-search")
    suspend fun complexSearchUsers(
        @Path("folder") folder: String = "users",
        @Body request: ComplexSearchRequest
    ): List<UserDto>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: String): UserDto
}
