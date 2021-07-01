package com.example.fanfiq.responses

import com.example.fanfiq.models.User
import com.google.gson.annotations.SerializedName

data class LoginResponse (
        @SerializedName("code")
        var statusCode: Int,

        @SerializedName("token")
        var authToken: String,

        @SerializedName("user")
        var user: User
)