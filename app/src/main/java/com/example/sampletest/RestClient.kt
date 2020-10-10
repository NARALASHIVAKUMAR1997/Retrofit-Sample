package com.example.sampletest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    companion object {
        val baseURL = "https://banking-appi-ly.herokuapp.com"
        lateinit var retrofit: Retrofit
        fun getInstance(): Retrofit {
            retrofit = Retrofit.Builder().baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create()).build()
            return retrofit
        }
    }

}