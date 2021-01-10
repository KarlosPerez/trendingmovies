package com.karlosprojects.trendingmovies.network

import com.karlosprojects.trendingmovies.model.Movies
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("trending/all/day?api_key={api_key}")
    fun getTrendingMovie(@Path("api_key") apiKey : String): Single<Movies>
}