package com.banklannister.cinema.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.banklannister.cinema.Extensions.EXTRA_MOVIES
import com.banklannister.cinema.Extensions.IMAGE_BASE
import com.banklannister.cinema.databinding.MovieItemBinding
import com.banklannister.cinema.models.Movie
import com.banklannister.cinema.ui.DetailMovieActivity
import com.bumptech.glide.Glide


class MovieAdapter(private val movies: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(private val itemBinding: MovieItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bindMovie(movie: Movie) {
            itemBinding.apply {
                textMovieTitleCardView.text = movie.title
                textMovieDesc.text = movie.overview
                Glide.with(imgMovieCardView).load(IMAGE_BASE + movie.poster).into(imgMovieCardView)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemBinding = MovieItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bindMovie(movies[position])

        holder.itemView.setOnClickListener {
            moveToMovieDetail(movie, it)
        }

    }

    override fun getItemCount(): Int = movies.size

    private fun moveToMovieDetail(movie: Movie, it: View) {
        val detailMovieIntent = Intent(it.context, DetailMovieActivity::class.java)
        detailMovieIntent.putExtra(EXTRA_MOVIES, movie)
        it.context.startActivity(detailMovieIntent)
    }


}