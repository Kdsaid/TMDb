package com.example.tmdb.domain.impl

import com.example.tmdb.data.MovieRepository
import com.example.tmdb.domain.GetMovieUseCase
import tuver.movies.model.MovieModel
import javax.inject.Inject

class GetMovieUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : GetMovieUseCase {

    override suspend fun getMovieUseCase(movieId: Int): Result<MovieModel> {
        return movieRepository.getMovie(movieId)
    }

}