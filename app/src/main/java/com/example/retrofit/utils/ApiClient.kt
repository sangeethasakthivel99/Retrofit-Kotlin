package com.example.retrofit.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var base_url :String ="https://api.themoviedb.org/3/"
    var retrofit: Retrofit? = null

    fun getClient():Retrofit{
        if(retrofit == null){
           retrofit = Retrofit.Builder()
               .baseUrl(base_url)
               .addConverterFactory(GsonConverterFactory.create())
               .build()
        }

        return retrofit as Retrofit
    }
}