package com.example.tugasppb.network

import com.example.tugasppb.model.ListBerita
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface BeritaService {

    @GET("container_select.php")
    fun getBerita(): Call<ArrayList<ListBerita>>

    @Multipart
    @POST("insert.php")
    fun insBerita(
        @Part("title") title: RequestBody,
        @Part("desc") desc: RequestBody,
        @Part("date") date: RequestBody,
        @Part("image\"; filename=\"myfile.jpg\" ") image: RequestBody): Call<ArrayList<ListBerita>>
//    @POST("add/")
//    fun addUser(@Body user: User?): Call<User?>?
//
//    @PUT("update/{id}")
//    fun updateUser(@Path("id") id: Int, @Body user: User?): Call<User?>?
//
//    @DELETE("delete/{id}")
//    fun deleteUser(@Path("id") id: Int): Call<User?>?
}