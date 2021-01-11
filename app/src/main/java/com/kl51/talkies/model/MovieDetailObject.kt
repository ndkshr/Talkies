package com.kl51.talkies.model

import com.google.gson.annotations.SerializedName

data class MovieDetailObject (
    @SerializedName("id")
    val id: Int,
    @SerializedName("genres")
    val genres: List<Genre>,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompanies>,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("tagline")
    val tagline: String,
    @SerializedName("budget")
    val budget: Int,
    @SerializedName("popularity")
    val popularity: Float
)
