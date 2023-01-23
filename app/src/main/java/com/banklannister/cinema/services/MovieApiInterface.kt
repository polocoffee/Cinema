package com.banklannister.cinema.services

import com.banklannister.cinema.Extensions.END_POINT_MOVIE
import com.banklannister.cinema.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {
    @GET(END_POINT_MOVIE)
    fun getMovieList(): Call<MovieResponse>
}