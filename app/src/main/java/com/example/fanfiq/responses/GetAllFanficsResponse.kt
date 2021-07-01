package com.example.fanfiq.responses

import com.google.gson.annotations.SerializedName

data class GetAllFanficsResponse(
        @SerializedName("id")
        var id: Long,

        @SerializedName("creation_date")
        var creation_date: String,

        @SerializedName("fanfic")
        var fanfic: String,

        @SerializedName("fanfic_name")
        var fanfic_name: String,

        @SerializedName("creator_username")
        var creator_username: String,

        @SerializedName("count_likes")
        var count_likes: Int

)