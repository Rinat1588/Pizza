package com.example.retrofitdemo.model.Product

import com.google.gson.annotations.SerializedName

data class ApiResponseProduct(
    @SerializedName("data"    ) var data    : ArrayList<Product> = arrayListOf(),
    @SerializedName("success" ) var success : Boolean?        = null

)
