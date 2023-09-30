package com.example.tmdb.ui.movie.movielist

import androidx.paging.PagingData
import com.example.tmdb.domain.GetMovieSummaryListPagingDataUseCase
import com.example.tmdb.model.MovieSummaryModel
import com.example.tmdb.presentation.movielist.MovieListViewModel
import com.example.tmdb.ui.BaseViewModelTest
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import kotlin.random.Random

@OptIn(ExperimentalCoroutinesApi::class)
class MovieListViewModelTest : BaseViewModelTest() {

    private val pageSize = Random.nextInt()

    private val mockGetMovieSummaryListPagingDataUseCase: GetMovieSummaryListPagingDataUseCase = mockk()

    private val movieListViewModel = MovieListViewModel(
        pageSize,
        mockGetMovieSummaryListPagingDataUseCase
    )

    @Test
    fun `should get paging flow from use case and emit it`() = runTest {
        // given
        val expectedPagingData: PagingData<MovieSummaryModel> = PagingData.from(listOf())
        every {
            mockGetMovieSummaryListPagingDataUseCase.getMovieSummaryListPagingData(eq(pageSize))
        } returns flowOf(expectedPagingData)

        // when
        val pagingData = movieListViewModel.movieSummaryListPagingDataFlow.first()

        // then
        verify {
            mockGetMovieSummaryListPagingDataUseCase.getMovieSummaryListPagingData(eq(pageSize))
        }
        confirmVerified(mockGetMovieSummaryListPagingDataUseCase)
        Assert.assertNotNull(pagingData)
    }

}