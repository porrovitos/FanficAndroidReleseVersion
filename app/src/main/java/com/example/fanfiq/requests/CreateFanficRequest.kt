package com.example.fanfiq.requests

import com.google.gson.annotations.SerializedName

data class CreateFanficRequest (

        @SerializedName("fanfic_name")
        var fanfic_name: String,

        @SerializedName("creator_username")
        var creator_username: String,

        @SerializedName("fanfic")
        var fanfic: String
)