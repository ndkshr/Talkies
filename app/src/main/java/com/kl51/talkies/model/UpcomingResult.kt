package com.kl51.talkies.model

import com.google.gson.annotations.SerializedName

data class UpcomingResult(
        @SerializedName("dates")
        val dates: ReleaseDates,
        @SerializedName("page")
        val page: Int,
        @SerializedName("results")
        val results: List<Movie>,
        @SerializedName("total_pages")
        val totalPages: Int,
        @SerializedName("total_results")
        val totalResult: Int
)
