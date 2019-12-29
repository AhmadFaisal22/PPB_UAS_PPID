package com.example.tugasppb.network

import com.example.tugasppb.model.ListBerita
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface BeritaService {

    @GET("container_select.php")
    fun getBerita(): Call<ArrayList<ListBerita>>

    @Multipart
    @POST("insert.php")
    fun insBerita(
        @Part("title") title: RequestBody,
        @Part("desc") desc: RequestBody,
        @Part("date") date: RequestBody,
        @Part("image\"; filename=\"myfile.jpg\" ") image: RequestBody
    ): Call<ArrayList<ListBerita>>

    @Multipart
    @POST("update.php")
    fun updBerita(
        @Part("title") title: RequestBody,
        @Part("desc") desc: RequestBody,
        @Part("date") date: RequestBody,
        @Part("image\"; filename=\"myfile.jpg\" ") image: RequestBody,
        @Part("id") id: RequestBody
    ): Call<ArrayList<ListBerita>>

    @Multipart
    @POST("update.php")
    fun updBeritaNoImage(
        @Part("title") title: RequestBody,
        @Part("desc") desc: RequestBody,
        @Part("date") date: RequestBody,
        @Part("image") image: RequestBody,
        @Part("id") id: RequestBody
    ): Call<ArrayList<ListBerita>>

    @GET("delete.php")
    fun dalBerita(
        @Query("id") id: String
    ): Call<String>
}