package com.example.tmdb.data.di

import com.example.tmdb.data.MovieRepository
import com.example.tmdb.data.MovieSummaryRepository
import com.example.tmdb.data.source.CachedMovieRepository
import com.example.tmdb.data.source.CachedMovieSummaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    abstract fun bindMovieSummaryRepository(cachedMovieSummaryRepository: CachedMovieSummaryRepository): MovieSummaryRepository


    @Binds
    @Singleton
    abstract fun bindMovieRepository(cachedMovieRepository: CachedMovieRepository): MovieRepository

}