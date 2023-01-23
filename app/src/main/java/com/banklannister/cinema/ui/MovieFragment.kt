package com.banklannister.cinema.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.banklannister.cinema.adapter.MovieAdapter
import com.banklannister.cinema.databinding.FragmentMovieBinding
import com.banklannister.cinema.models.Movie
import com.banklannister.cinema.models.MovieResponse
import com.banklannister.cinema.services.MovieApiInterface
import com.banklannister.cinema.services.MovieApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding
    private val movies = arrayListOf<Movie>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvMovieList.layoutManager = LinearLayoutManager(this.context)
        binding.rvMovieList.setHasFixedSize(true)

        getMovieData() { movies: List<Movie> ->
            binding.rvMovieList.adapter = MovieAdapter(movies)
        }
        showRecyclerView()
    }


    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return callback(response.body()!!.movies)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })
    }

    private fun showRecyclerView() {
        binding.rvMovieList.layoutManager = LinearLayoutManager(this.context)
        binding.rvMovieList.adapter = MovieAdapter(movies)

    }
}
