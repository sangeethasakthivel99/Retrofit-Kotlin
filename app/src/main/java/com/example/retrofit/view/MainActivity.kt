package com.example.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.model.Movies
import com.example.retrofit.model.Result
import com.example.retrofit.utils.ApiClient
import com.example.retrofit.utils.ApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var movieList:List<Result> = mutableListOf()
    private var apiKey = "6e63c2317fbe963d76c3bdc2b785f6d1"
    private var page = 1
    private  var client: Retrofit = ApiClient.getClient()
    private var service:ApiService = client.create(ApiService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        service.getPopularMovies(page++,apiKey).enqueue(object: Callback<Movies>{

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Log.e("failed","Failed")
            }

            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {
                movieList = response.body()!!.results
                recycler_view.layoutManager = LinearLayoutManager(parent)
                Log.e("pssing to adapter",movieList.toString())
                recycler_view.adapter = RecyclerViewAdapter(movieList)
                recycler_view.setHasFixedSize(true)
            }
        })
    }
}
