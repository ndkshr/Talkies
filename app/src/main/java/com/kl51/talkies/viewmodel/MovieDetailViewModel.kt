package com.kl51.talkies.viewmodel

import androidx.lifecycle.ViewModel
import com.kl51.talkies.network.MovieApi
import com.kl51.talkies.network.MovieRepository
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(
    private val movieRepository: MovieRepository
): ViewModel() {

    fun getMovieDetails(movieId: String) = movieRepository.getMovieDetails(movieId)
}
