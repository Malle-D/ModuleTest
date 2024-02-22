package com.example.secondtest.di

import com.example.secondtest.utils.navigation.AppNavigationDispatcher
import com.example.secondtest.utils.navigation.AppNavigationHandler
import com.example.secondtest.utils.navigation.AppNavigator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @[Binds Singleton]
    fun bindHandler(impl: AppNavigationDispatcher): AppNavigationHandler

    @[Binds Singleton]
    fun bindNavigator(impl: AppNavigationDispatcher): AppNavigator
}