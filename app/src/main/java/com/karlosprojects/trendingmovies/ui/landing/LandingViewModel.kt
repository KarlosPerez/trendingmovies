package com.karlosprojects.trendingmovies.ui.landing

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.karlosprojects.trendingmovies.model.Movie
import com.karlosprojects.trendingmovies.repository.MovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers

class LandingViewModel @ViewModelInject constructor(
    movieRepository: MovieRepository
) : ViewModel() {
    private val _trendingMovies = MutableLiveData<Movie>()
    val trendingMovies : LiveData<Movie>
        get() = _trendingMovies

    init {
        movieRepository.gettrendingMovies()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
    }
}