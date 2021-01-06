package com.kl51.talkies.network

import com.kl51.talkies.BuildConfig
import com.kl51.talkies.model.Movie
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {
    @GET("/movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String = BuildConfig.API_KEY,
        @Query("language") language: String = "en",
        @Query("region") region: String = "US"
    ): Single<List<Movie>>
}
