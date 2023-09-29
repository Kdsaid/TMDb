package com.example.tmdb.data

import tuver.movies.model.MovieModel

interface MovieRepository {

    suspend fun getMovie(movieId: Int): Result<MovieModel>

}