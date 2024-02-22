package com.example.domain.repository

import com.example.domain.model.request.AppRequest
import com.example.domain.model.response.AppResponse
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getAllBooks(request: AppRequest) : Flow<Result<AppResponse>>
}