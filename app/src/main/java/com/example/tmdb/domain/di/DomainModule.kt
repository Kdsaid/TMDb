package com.example.tmdb.domain.di

import com.example.tmdb.domain.GetMovieSummaryListPagingDataUseCase
import com.example.tmdb.domain.GetMovieUseCase
import com.example.tmdb.domain.impl.GetMovieSummaryListPagingDataUseCaseImpl
import com.example.tmdb.domain.impl.GetMovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    @Singleton
    abstract fun bindGetMovieSummaryListPagingDataUseCase(
        getMovieSummaryListPagingDataUseCaseImpl: GetMovieSummaryListPagingDataUseCaseImpl
    ): GetMovieSummaryListPagingDataUseCase

    @Binds
    @Singleton
    abstract fun bindGetMovieUseCase(getMovieUseCaseImpl: GetMovieUseCaseImpl): GetMovieUseCase

}