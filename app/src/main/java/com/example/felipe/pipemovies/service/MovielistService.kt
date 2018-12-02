package com.example.felipe.pipemovies.service

import com.example.felipe.pipemovies.model.Movielist
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

public interface MovielistService {

    @GET("upcoming")
    fun getUpcoming(@Query("api_key") apiKey: String): Single<Movielist>
}