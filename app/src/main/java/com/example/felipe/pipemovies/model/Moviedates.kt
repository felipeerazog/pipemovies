package com.example.felipe.pipemovies.model

import com.google.gson.annotations.SerializedName

data class Moviedates (
    @SerializedName("maximum") val maximum: String,
    @SerializedName("minimum") val minimum: String
) {
    override fun toString():String {
        return "$minimum to $maximum"
    }
}