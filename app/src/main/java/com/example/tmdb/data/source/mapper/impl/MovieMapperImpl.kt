package com.example.tmdb.data.source.mapper.impl

import com.example.tmdb.data.source.dto.MovieDto
import com.example.tmdb.data.source.mapper.MovieMapper
import com.example.tmdb.model.MovieModel
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.inject.Named

class MovieMapperImpl @Inject constructor(
    @Named("releaseDateFormat") private val releaseDateFormat: SimpleDateFormat
) : MovieMapper {

    override fun toModel(dto: MovieDto): MovieModel {
        return dto.run {
            MovieModel(
                id,
                title,
                overview,
                releaseDateFormat.parse(releaseDate),
                posterImageUrlPath,
                backdropImageUrlPath,
                runtimeInMinutes
            )
        }
    }

}