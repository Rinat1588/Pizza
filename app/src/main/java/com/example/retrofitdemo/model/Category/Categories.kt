package com.example.retrofitdemo.model.Category

import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("id_category" ) var idCategory : Int?    = null,
    @SerializedName("category"    ) var category   : String? = null
)
