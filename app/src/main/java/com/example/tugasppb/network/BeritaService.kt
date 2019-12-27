package com.example.tugasppb.network

import com.example.tugasppb.model.ListBerita
import retrofit2.Call
import retrofit2.http.GET


interface BeritaService {

    @GET("container_select.php")
    fun getBerita(): Call<ArrayList<ListBerita>>

//    @POST("add/")
//    fun addUser(@Body user: User?): Call<User?>?
//
//    @PUT("update/{id}")
//    fun updateUser(@Path("id") id: Int, @Body user: User?): Call<User?>?
//
//    @DELETE("delete/{id}")
//    fun deleteUser(@Path("id") id: Int): Call<User?>?
}