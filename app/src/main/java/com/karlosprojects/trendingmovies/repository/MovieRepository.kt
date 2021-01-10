package com.karlosprojects.trendingmovies.repository

import com.karlosprojects.trendingmovies.BuildConfig
import com.karlosprojects.trendingmovies.model.Movies
import com.karlosprojects.trendingmovies.network.MovieService
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepository @Inject constructor(
    private val movieService: MovieService
) {
    fun gettrendingMovies(): Single<Movies> {
        return movieService.getTrendingMovie(BuildConfig.themoviedb_apikey)
            .subscribeOn(Schedulers.io())
    }
}