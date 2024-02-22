package com.example.domain.usecase

import com.example.domain.model.request.AppRequest
import com.example.domain.model.response.AppResponse
import kotlinx.coroutines.flow.Flow

interface GetAllBooksUseCase {
    fun getAllBooks(request: AppRequest) : Flow<Result<AppResponse>>
}