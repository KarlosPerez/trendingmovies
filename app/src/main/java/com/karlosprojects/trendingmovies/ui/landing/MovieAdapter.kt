package com.karlosprojects.trendingmovies.ui.landing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.karlosprojects.trendingmovies.databinding.ItemMovieBinding
import com.karlosprojects.trendingmovies.di.GlideApp
import com.karlosprojects.trendingmovies.model.Movie

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private var movieList : List<Movie> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movieList[position]
        holder.bind(movie)
    }

    fun setMovies(movieList : List<Movie>) {
        this.movieList = movieList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = movieList.size

    class MovieViewHolder(val viewMovieBinding: ItemMovieBinding ) : RecyclerView.ViewHolder(viewMovieBinding.root) {

        fun bind(movie : Movie) {
            viewMovieBinding.apply {
                GlideApp.with(ivPoster)
                    .load("https://image.tmdb.org/t/p/w500${movie.posterPath}")
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                tvOverview.text = movie.overview
            }
        }

        companion object {
            fun from(parent : ViewGroup) : MovieViewHolder {
                val itemView = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return MovieViewHolder(itemView)
            }
        }

    }
}