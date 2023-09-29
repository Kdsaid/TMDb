package com.example.tmdb.data

import androidx.paging.PagingData
import com.example.tmdb.model.MovieSummaryModel
import kotlinx.coroutines.flow.Flow

interface MovieSummaryRepository {

    fun getMovieSummaryListPagingData(pageSize: Int): Flow<PagingData<MovieSummaryModel>>

}