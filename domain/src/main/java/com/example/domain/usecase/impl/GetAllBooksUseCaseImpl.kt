package com.example.domain.usecase.impl

import com.example.domain.model.request.AppRequest
import com.example.domain.model.response.AppResponse
import com.example.domain.repository.AppRepository
import com.example.domain.usecase.GetAllBooksUseCase
import kotlinx.coroutines.flow.Flow

class GetAllBooksUseCaseImpl constructor(
    private val appRepository: AppRepository
) : GetAllBooksUseCase {
    override fun getAllBooks(request: AppRequest): Flow<Result<AppResponse>> = appRepository.getAllBooks(request)
}