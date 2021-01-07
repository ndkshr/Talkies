package com.kl51.talkies.viewmodel

import androidx.lifecycle.ViewModel
import com.kl51.talkies.network.MovieRepository
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
        private val repository: MovieRepository
) : ViewModel() {

    fun getUpcomingMovies() = repository.getUpcomingMovies()

    fun getConfiguration() = repository.getConfiguration()
}
