package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

data class CreateUserRequestDto(
    @SerializedName("userName")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("passwd")
    val password: String,

    @SerializedName("profileImageId")
    val profileImageId: String = ""
)

data class CreateUserResponseDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("message")
    val message: String
)
