package com.kl51.talkies.model

import com.google.gson.annotations.SerializedName

data class ReleaseDates(
        @SerializedName("maximum")
        val maximum: String,
        @SerializedName("minimum")
        val minimum: String
)