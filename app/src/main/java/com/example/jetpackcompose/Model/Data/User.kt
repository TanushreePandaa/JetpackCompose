package com.example.jetpackcompose.Model.Data

import com.google.gson.annotations.SerializedName

data class User (
    val id: Int,
    val email: String,
    @SerializedName("username")
    val userName: String,
    @SerializedName("password")
    val pass: String,
    val name: Name
)
data class Name (
    val firstname: String,
    val lastname: String
)

