package com.karlosprojects.trendingmovies.network

import com.karlosprojects.trendingmovies.model.Movies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("trending/all/day")
    fun getTrendingMovie(@Query("api_key") apiKey : String): Single<Movies>
}