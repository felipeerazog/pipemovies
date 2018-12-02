package com.example.felipe.pipemovies.model

import com.google.gson.annotations.SerializedName

public data class Moviedates (
    @SerializedName("maximum") val maximum: String,
    @SerializedName("minimum") val minimum: String
)