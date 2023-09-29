package com.example.tmdb.data

import com.example.tmdb.model.MovieModel

interface MovieRepository {

    suspend fun getMovie(movieId: Int): Result<MovieModel>

}