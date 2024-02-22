package com.example.data.di

import com.example.domain.usecase.GetAllBooksUseCase
import com.example.domain.usecase.impl.GetAllBooksUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {
    @Binds
    fun getAllUseCaseBinder(impl: GetAllBooksUseCaseImpl): GetAllBooksUseCase
}