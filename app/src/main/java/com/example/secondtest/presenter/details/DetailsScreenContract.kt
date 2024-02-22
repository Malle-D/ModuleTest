package com.example.secondtest.presenter.details


sealed interface DetailsScreenContract {
    interface ViewModel{
        fun onEventDispatcher(intent: Intent)
    }
    interface Intent {
        object BackToHomeScreen : Intent
    }
}