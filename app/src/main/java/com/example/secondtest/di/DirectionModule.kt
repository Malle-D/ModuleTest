package com.example.secondtest.di

import com.example.secondtest.presenter.details.DetailsDirection
import com.example.secondtest.presenter.details.DetailsDirectionImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {

    @Binds
    fun bindDetailsScreenDirection(impl : DetailsDirectionImpl) : DetailsDirection
}