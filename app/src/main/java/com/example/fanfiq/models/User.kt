package com.example.fanfiq.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class User (

    @SerializedName("id")
    @Expose
    val id: String,

    @SerializedName("active")
    @Expose
    var active: Boolean,

    @SerializedName("admin")
    @Expose
    var admin: Boolean,

    @SerializedName("birth_date")
    @Expose
    var birth_date: Date,

    @SerializedName("email")
    @Expose
    var email: String,

    @SerializedName("email_confirmed")
    @Expose
    var email_confirmed: Boolean,

    @SerializedName("password")
    @Expose
    var password: String,

    @SerializedName("registration_date")
    @Expose
    var registration_date: Date,

    @SerializedName("username")
    @Expose
    var username: String

)
