package com.example.fanfiq.responses

import com.google.gson.annotations.SerializedName

data class RegistrationResponse(
        @SerializedName("code")
        var statusCode: Int
)