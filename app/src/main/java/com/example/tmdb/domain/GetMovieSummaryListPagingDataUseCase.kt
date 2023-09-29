package com.example.tmdb.domain

import androidx.paging.PagingData
import com.example.tmdb.model.MovieSummaryModel
import kotlinx.coroutines.flow.Flow

interface GetMovieSummaryListPagingDataUseCase {

    fun getMovieSummaryListPagingData(pageSize: Int): Flow<PagingData<MovieSummaryModel>>

}