package com.example.secondtest.presenter.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.request.AppRequest
import com.example.domain.usecase.GetAllBooksUseCase
import com.example.secondtest.presenter.details.DetailsScreen
import com.example.secondtest.utils.mapper.toSimple
import com.example.secondtest.utils.navigation.AppNavigator
import com.example.testmission.data.model.simple.BookModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModelImpl @Inject constructor(
    private val gelAllBooksUseCase: GetAllBooksUseCase,
    private val appNavigator: AppNavigator
//    private val direction: HomeScreenDirection
) : HomeScreenViewModel, ViewModel() {
    init {
        loadData()
    }

    override val booksState: MutableStateFlow<List<BookModel>> = MutableStateFlow(listOf())

    override val isLoading: MutableStateFlow<Boolean> = MutableStateFlow(true)

    private fun loadData() {
        gelAllBooksUseCase.getAllBooks(AppRequest(178))
            .onEach { it ->
                it.onSuccess { ls ->
                    val list = mutableListOf<BookModel>()
                    list.addAll(ls.data.books.map { it.toSimple() })
                    booksState.emit(value = list)
                    isLoading.emit(value = false)
                }
            }.launchIn(viewModelScope)
    }

    override fun openDetails(bookData: BookModel) {
        viewModelScope.launch {
            appNavigator.addScreen(DetailsScreen(bookData))
        }
    }
}