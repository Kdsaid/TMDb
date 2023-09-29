package com.example.tmdb.data.source.mapper.impl

import com.example.tmdb.data.source.dto.MovieSummaryDto
import com.example.tmdb.data.source.mapper.MovieSummaryMapper
import com.example.tmdb.model.MovieSummaryModel
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Named

class MovieSummaryMapperImpl @Inject constructor(
    @Named("releaseDateFormat") private val releaseDateFormat: SimpleDateFormat
) : MovieSummaryMapper {

    override fun toModel(dto: MovieSummaryDto): MovieSummaryModel {
        return dto.run {
            MovieSummaryModel(
                id,
                title,
                overview,
                releaseDateFormat.parse(releaseDate),
                posterImageUrlPath
            )
        }
    }

}