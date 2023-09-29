package com.example.tmdb.data.source.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tmdb.data.source.dto.MovieSummaryDto

@Dao
interface MovieSummaryDao {

    @Query("SELECT * FROM ${MovieSummaryDto.DB_TABLE_NAME} order by ${MovieSummaryDto.FIELD_NAME_ORDER} ASC")
    fun selectPagingSource(): PagingSource<Int, MovieSummaryDto>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(movieSummaryDtoList: List<MovieSummaryDto>)

    @Query("DELETE FROM ${MovieSummaryDto.DB_TABLE_NAME}")
    fun deleteAll()

}