package com.example.secondtest.presenter.details

import com.example.secondtest.utils.navigation.AppNavigator
import javax.inject.Inject

interface DetailsDirection {
    suspend fun backToHome()
}
class DetailsDirectionImpl @Inject constructor(
    private val appNavigator: AppNavigator
): DetailsDirection {
    override suspend fun backToHome() {
        appNavigator.back()
    }

}