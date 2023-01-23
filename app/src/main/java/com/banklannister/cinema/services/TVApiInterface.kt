package com.banklannister.cinema.services

import com.banklannister.cinema.Extensions.END_POINT_TV
import com.banklannister.cinema.models.TVResponse
import retrofit2.Call
import retrofit2.http.GET

interface TVApiInterface {
    @GET(END_POINT_TV)
    fun getTVList(): Call<TVResponse>
}