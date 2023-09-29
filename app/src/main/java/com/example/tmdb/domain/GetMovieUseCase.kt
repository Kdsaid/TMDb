package com.example.tmdb.domain

import com.example.tmdb.model.MovieModel

interface GetMovieUseCase {

    suspend fun getMovieUseCase(movieId: Int): Result<MovieModel>

}