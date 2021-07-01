package com.example.fanfiq.responses

import com.google.gson.annotations.SerializedName

data class CreateFanficResponse (
        @SerializedName("code")
        var statusCode: Int
)