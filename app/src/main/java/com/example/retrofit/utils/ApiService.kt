package com.example.retrofit.utils

import com.example.retrofit.model.Movies
import com.example.retrofit.model.Result
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import kotlin.Result as Result1


interface ApiService {

    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int, @Query("api_key") apiKey: String?):Call<Movies>

}