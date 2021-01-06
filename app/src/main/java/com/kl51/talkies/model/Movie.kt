package com.kl51.talkies.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id")
    val movieId: Int,
    @SerializedName("title")
    val movieName: String,
    val moviePosterUrl: String,
    val movieRating: String,
    val movieGenre: List<Genre>
)

data class Genre (
    val id: Int,
    val name: String
)
