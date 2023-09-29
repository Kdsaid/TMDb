package com.example.tmdb.presentation.movielist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.tmdb.domain.GetMovieSummaryListPagingDataUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject

class MovieListViewModel @AssistedInject constructor(
    @Assisted pageSize: Int,
    getMovieSummaryListPagingDataUseCase: GetMovieSummaryListPagingDataUseCase
) : ViewModel() {
//    private val mutableNavigation = MutableStateFlow<MovieSummaryModel>(emptyFlow<>())
//
//    val navigation: StateFlow<MovieListNavigation>
//        get() = mutableNavigation



    val movieSummaryListPagingDataFlow by lazy {
        getMovieSummaryListPagingDataUseCase
            .getMovieSummaryListPagingData(pageSize)
            .cachedIn(viewModelScope)
    }

    companion object {

        @AssistedFactory
        interface Factory {

            fun create(pageSize: Int): MovieListViewModel

        }

    }

}