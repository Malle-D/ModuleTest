package com.example.data.repository

import com.example.data.api.Api
import com.example.domain.model.request.AppRequest
import com.example.domain.model.response.AppResponse
import com.example.domain.repository.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val appApi: Api
) : AppRepository {
    override fun getAllBooks(request: AppRequest): Flow<Result<AppResponse>> =
        flow<Result<AppResponse>> {
            val response = appApi.getAllBooks(
                request,
                "Bearer bGlmZXN0eWxlOjY0YzBkMGZlYzcwOGU1MDYyMWViZDMxNA=="
            )
            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!))
            } else {
                emit(Result.failure(IllegalArgumentException("error")))
            }
        }.flowOn(Dispatchers.IO).catch {
            emit(Result.failure(it))
        }
}