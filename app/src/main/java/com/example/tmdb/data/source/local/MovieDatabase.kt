package com.example.tmdb.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tmdb.data.source.dto.MovieDto
import com.example.tmdb.data.source.dto.MovieSummaryDto
import com.example.tmdb.data.source.dto.RemoteKeyDto
import com.example.tmdb.data.source.local.MovieDatabase.Companion.VERSION

@Database(entities = [MovieSummaryDto::class, MovieDto::class, RemoteKeyDto ::class], version = VERSION)
abstract class MovieDatabase : RoomDatabase() {

    abstract fun movieSummaryDao(): MovieSummaryDao

    abstract fun remoteKeyDao(): RemoteKeyDao

    abstract fun movieDao(): MovieDao

    companion object {

        const val VERSION = 1
        const val NAME = "movie-db"

    }

}