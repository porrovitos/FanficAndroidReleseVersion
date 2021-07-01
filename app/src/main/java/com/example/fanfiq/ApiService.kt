package com.example.fanfiq

import com.example.fanfiq.requests.CreateFanficRequest
import com.example.fanfiq.requests.LoginRequest
import com.example.fanfiq.requests.RegistrationRequest
import com.example.fanfiq.responses.CreateFanficResponse
import com.example.fanfiq.responses.GetAllFanficsResponse
import com.example.fanfiq.responses.LoginResponse
import com.example.fanfiq.responses.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


/**
 * Interface for defining REST request functions
 */

interface ApiService {

    @POST("http://192.168.100.6:97/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("http://192.168.100.6:97/registration")
    fun registration(@Body request: RegistrationRequest): Call<RegistrationResponse>

    @POST("http://192.168.100.6:97/fanfic/create")
    fun createFanfic(@Body request: CreateFanficRequest): Call<CreateFanficResponse>

    @GET("http://192.168.100.6:97/fanfic")
    fun getAllFanfics(): Call<List<GetAllFanficsResponse>>

}