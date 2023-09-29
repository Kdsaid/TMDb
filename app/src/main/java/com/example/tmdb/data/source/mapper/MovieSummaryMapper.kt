package com.example.tmdb.data.source.mapper

import com.example.tmdb.data.source.dto.MovieSummaryDto
import com.example.tmdb.model.MovieSummaryModel

interface MovieSummaryMapper {

    fun toModel(dto: MovieSummaryDto): MovieSummaryModel

}