package com.example.pmdm.data.dto

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("userName")
    val username: String,

    @SerializedName("email")
    val email: String,

    @SerializedName("passwd")
    val password: String,

    @SerializedName("profileImageId")
    val profileImageId: String? = ""
)
