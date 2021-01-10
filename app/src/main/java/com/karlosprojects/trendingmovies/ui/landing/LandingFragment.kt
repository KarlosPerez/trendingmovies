package com.karlosprojects.trendingmovies.ui.landing

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.karlosprojects.trendingmovies.R
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class LandingFragment : Fragment(R.layout.landing_fragment) {

    private val landingViewModel by viewModels<LandingViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        landingViewModel.trendingMovies.observe(viewLifecycleOwner, Observer {
            Timber.i("success")
        })
    }
}