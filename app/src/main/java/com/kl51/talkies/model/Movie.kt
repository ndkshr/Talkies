package com.kl51.talkies.model

data class Movie(
    val movieId: Int,
    val movieName: String,
    val moviePosterUrl: String,
    val movieRating: String,
    val movieGenre: List<Genre>
)

data class Genre (
    val id: Int,
    val name: String
)
