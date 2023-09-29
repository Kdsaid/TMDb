package com.example.tmdb.presentation.movielist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.tmdb.R
import com.example.tmdb.databinding.FragmentMovieListBinding
import com.example.tmdb.presentation.movielist.adapter.MovieSummaryAdapter
import com.example.tmdb.provider.MovieImageProvider
import com.example.tmdb.util.Constants.MOVIE_LIST_PAGE_SIZE
import com.example.tmdb.util.extension.viewModelsFactory
import com.example.tmdb.util.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {
    private val binding by viewBinding<FragmentMovieListBinding>()

    @Inject
    lateinit var movieImageProvider: MovieImageProvider

    @Inject
    lateinit var viewModelFactory: MovieListViewModel.Companion.Factory

    private val viewModel: MovieListViewModel by viewModelsFactory { viewModelFactory.create(MOVIE_LIST_PAGE_SIZE) }

    private val movieSummaryAdapter by lazy { MovieSummaryAdapter(movieImageProvider) {it-> } }




    private fun setupRecyclerView() {
        binding.movieRecyclerView.apply {
            adapter = movieSummaryAdapter
        }
    }





    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        lifecycleScope.launch {
            viewModel.movieSummaryListPagingDataFlow.collectLatest { pagingData ->
                movieSummaryAdapter.submitData(pagingData)
            }
        }
    }

}