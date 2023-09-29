package com.example.tmdb.domain.impl

import androidx.paging.PagingData
import com.example.tmdb.data.MovieSummaryRepository
import com.example.tmdb.domain.GetMovieSummaryListPagingDataUseCase
import com.example.tmdb.model.MovieSummaryModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMovieSummaryListPagingDataUseCaseImpl @Inject constructor(
    private val movieSummaryRepository: MovieSummaryRepository
) : GetMovieSummaryListPagingDataUseCase {

    override fun getMovieSummaryListPagingData(pageSize: Int): Flow<PagingData<MovieSummaryModel>> {
        return movieSummaryRepository.getMovieSummaryListPagingData(pageSize)
    }

}