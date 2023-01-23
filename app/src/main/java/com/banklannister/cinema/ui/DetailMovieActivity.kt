package com.banklannister.cinema.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banklannister.cinema.Extensions.EXTRA_MOVIES
import com.banklannister.cinema.Extensions.IMAGE_BASE
import com.banklannister.cinema.databinding.ActivityDetailMovieBinding
import com.banklannister.cinema.models.Movie
import com.bumptech.glide.Glide


class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.imgDetailMovie.clipToOutline = true

        val detailMovies = intent.getParcelableExtra<Movie>(EXTRA_MOVIES)

        if (detailMovies != null) {
            Glide.with(this).load(IMAGE_BASE + detailMovies.poster)
                .into(binding.imgDetailMovie)
            binding.tvDetailMovieName.text = detailMovies.title
            binding.tvDetailMovieDesc.text = detailMovies.overview
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}