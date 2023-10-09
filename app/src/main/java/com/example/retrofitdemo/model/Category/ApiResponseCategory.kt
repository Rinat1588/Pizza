package com.example.retrofitdemo.model.Category

import com.google.gson.annotations.SerializedName

 data class ApiResponseCategory(

     @SerializedName("data"    ) var data    : ArrayList<Categories> = arrayListOf(),
     @SerializedName("success" ) var success : Boolean?        = null
)
