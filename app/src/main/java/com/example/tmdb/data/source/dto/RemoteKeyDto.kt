package com.example.tmdb.data.source.dto

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tmdb.data.source.dto.RemoteKeyDto.Companion.DB_TABLE_NAME
import com.google.gson.annotations.SerializedName

@Entity(DB_TABLE_NAME)
data class RemoteKeyDto(
    @PrimaryKey
    @ColumnInfo(FIELD_NAME_ID)
    @SerializedName(FIELD_NAME_ID)
    val id: String,

    @ColumnInfo(FIELD_NAME_PAGE)
    @SerializedName(FIELD_NAME_PAGE)
    val nextPageKey: Int?,
) {

    companion object {

        const val DB_TABLE_NAME = "movie_summary_page"
        const val FIELD_NAME_ID = "id"
        const val FIELD_NAME_PAGE = "page"

    }

}