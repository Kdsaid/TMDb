package com.example.tmdb.data.source.remote

import com.example.tmdb.data.source.dto.GetMovieListResponseDto
import com.example.tmdb.data.source.dto.MovieDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {

    @GET("discover/movie")
    suspend fun getMovieList(@Query("page") page: Int): GetMovieListResponseDto

    @GET("movie/{movie_id}")
    suspend fun getMovie(@Path("movie_id") movieId: Int): MovieDto

}