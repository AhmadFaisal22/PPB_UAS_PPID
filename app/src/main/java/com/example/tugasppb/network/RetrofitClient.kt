package com.example.tugasppb.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    val BASE_URL = "http://127.0.0.1:1234/tugas_ppid/"
    private var retrofit: Retrofit? = null
    var okHttpClient = OkHttpClient.Builder()
        .build()

    fun getClient(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}