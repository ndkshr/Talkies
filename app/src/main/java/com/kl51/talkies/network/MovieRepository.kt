package com.kl51.talkies.network

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MovieRepository @Inject constructor(
        private val movieApi: MovieApi
) {
    fun getUpcomingMovies() = movieApi.getUpcomingMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())

    fun getConfiguration() = movieApi.getConfiguration()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
}
