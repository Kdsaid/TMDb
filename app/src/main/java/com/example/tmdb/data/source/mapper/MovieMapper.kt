package com.example.tmdb.data.source.mapper

import com.example.tmdb.data.source.dto.MovieDto
import com.example.tmdb.model.MovieModel

interface MovieMapper {

    fun toModel(dto: MovieDto): MovieModel

}