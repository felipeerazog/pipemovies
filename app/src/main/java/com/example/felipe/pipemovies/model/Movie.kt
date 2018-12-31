package com.example.felipe.pipemovies.model

import com.google.gson.annotations.SerializedName

data class Movie (
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("popularity") val popularity: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String
)