package com.example.tmdb.presentation.moviedetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentMovieDetailBinding
import com.example.tmdb.model.MovieSummaryModel
import com.example.tmdb.provider.MovieImageProvider
import com.example.tmdb.util.extension.toYearString
import com.example.tmdb.util.navigateUp
import com.example.tmdb.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieDetailFragment : Fragment(R.layout.fragment_movie_detail) {
    private val binding by viewBinding<FragmentMovieDetailBinding>()

    @Inject
    lateinit var movieImageProvider: MovieImageProvider

    private val fragmentArgs: MovieDetailFragmentArgs by navArgs()


    @SuppressLint("StringFormatMatches")
    private fun onMovieModelArgs(movieModel: MovieSummaryModel) {
        with(binding) {
            movieImageProvider.loadBackdrop(movieBackdropImage, movieModel.posterImageUrlPath)
            movieImageProvider.loadPoster(moviePosterImage, movieModel.posterImageUrlPath)
            movieInfoText.text = movieModel.releaseDate.toYearString()
            movieTitleText.text = movieModel.title
            movieOverviewText.text = movieModel.overview
            backButton.setOnClickListener {
                navigateUp()
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onMovieModelArgs(fragmentArgs.movieSummaryModel)
    }


}