package com.example.sampletest

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    fun loadData(): Call<Example>
}