package com.example.tmdb.data.source.remote.di

import com.example.tmdb.BuildConfig
import com.example.tmdb.data.source.remote.MovieApi
import com.example.tmdb.data.source.remote.MovieApiConfigInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Provides
    fun provideMovieApiConfigInterceptor(): MovieApiConfigInterceptor {

        return MovieApiConfigInterceptor(
            BuildConfig.API_KEY
        )
    }

    @Provides
    fun provideOkHttpClient(movieApiConfigInterceptor: MovieApiConfigInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(movieApiConfigInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieApi(retrofit: Retrofit): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }

}