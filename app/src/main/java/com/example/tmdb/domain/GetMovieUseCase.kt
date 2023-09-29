package com.example.tmdb.domain

import tuver.movies.model.MovieModel

interface GetMovieUseCase {

    suspend fun getMovieUseCase(movieId: Int): Result<MovieModel>

}