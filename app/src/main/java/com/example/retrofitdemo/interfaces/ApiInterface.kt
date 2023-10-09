package com.example.retrofitdemo.interfaces

import retrofit2.Call
import com.example.retrofitdemo.model.Category.ApiResponseCategory
import com.example.retrofitdemo.model.Product.ApiResponseProduct
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiInterface {

    @Headers("Content-Type:application/json")
    @GET("categories")
    fun getAllCategories(): Call<ApiResponseCategory>

    @Headers("Content-Type:application/json")
    @GET("products")
    fun getAllProducts(): Call<ApiResponseProduct>
}