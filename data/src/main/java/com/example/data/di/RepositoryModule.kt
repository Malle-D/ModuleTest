package com.example.data.di

import com.example.data.repository.AppRepositoryImpl
import com.example.domain.repository.AppRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {
    @Binds
    fun repositoryBinder(impl: AppRepositoryImpl): AppRepository
}