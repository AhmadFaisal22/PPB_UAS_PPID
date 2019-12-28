package com.example.tugasppb.network

import com.example.tugasppb.network.RetrofitClient.getClient

object APIUtils {
    val beritaService: BeritaService
        get() = RetrofitClient.getClient()!!.create(BeritaService::class.java)

}