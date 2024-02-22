package com.example.secondtest.presenter.home

import com.example.testmission.data.model.simple.BookModel
import kotlinx.coroutines.flow.StateFlow

interface HomeScreenViewModel {

    val booksState: StateFlow<List<BookModel>>
    val isLoading: StateFlow<Boolean>

    fun openDetails(bookData: BookModel)

}