package com.example.felipe.pipemovies.model

import com.google.gson.annotations.SerializedName

data class Movielist (
        @SerializedName("results") val results: List<Movie>,
        @SerializedName("page") val page: Int,
        @SerializedName("dates") val dates: Moviedates,
        @SerializedName("total_pages") val totalPages: Int
)