package com.example.data.api


import com.example.data.model.model.request.AppRequest
import com.example.data.model.model.response.AppResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @POST("new/")
    suspend fun getAllBooks(
        @Body request: AppRequest,
        @Header("Authorization") token : String,
    ): Response<AppResponse>

}