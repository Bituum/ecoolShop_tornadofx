package com.example.remote.api

import retrofit2.http.POST

interface AuthApi {
    @POST
    suspend fun sendEmail()

    @POST
    suspend fun authenticate()
}