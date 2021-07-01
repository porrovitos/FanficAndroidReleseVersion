package com.example.fanfiq.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CreateFanfic (
    @SerializedName("count_likes")
    @Expose
    var count_likes: String,

    @SerializedName("fanfic")
    @Expose
    var fanfic: String,

    @SerializedName("fanfic_name")
    @Expose
    var fanfic_name: String,


    @SerializedName("creator_username")
    @Expose
    var creator_username: String
)
