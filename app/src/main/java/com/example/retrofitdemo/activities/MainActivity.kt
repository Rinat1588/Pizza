package com.example.retrofitdemo.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.adapters.CategoriesAdapter
import com.example.retrofitdemo.adapters.ProductsAdapter
import com.example.retrofitdemo.databinding.ActivityMainBinding
import com.example.retrofitdemo.datasource.ServiceBuilder
import com.example.retrofitdemo.interfaces.ApiInterface
import com.example.retrofitdemo.model.Category.ApiResponseCategory
import com.example.retrofitdemo.model.Category.Categories
import com.example.retrofitdemo.model.Product.ApiResponseProduct
import com.example.retrofitdemo.model.Product.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var categoryList = ArrayList<Categories>()
    var productList = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getAllCategories()
        getAllProducts()
    }






    private fun getAllCategories() {
        val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)
        retrofit.getAllCategories().enqueue(object: Callback<ApiResponseCategory> {
            override fun onResponse(call: Call<ApiResponseCategory>, response: Response<ApiResponseCategory>) {
                try {
                    val responseBody = response.body()!!
                    categoryList = responseBody.data

                    val adapter = CategoriesAdapter(categoryList)
                    binding.recyclerView.adapter=adapter
                }
                catch (ex:java.lang.Exception){
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponseCategory>, t: Throwable) {
               Log.e("Failed", "Api Failed" + t.message)
            }
        }
        )
    }


    private fun getAllProducts() {
        val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)
        retrofit.getAllProducts().enqueue(object: Callback<ApiResponseProduct> {
            override fun onResponse(call: Call<ApiResponseProduct>, response: Response<ApiResponseProduct>) {
                try {
                    val responseBody = response.body()!!
                    productList = responseBody.data

                    val adapter = ProductsAdapter(productList)
                    binding.pizzaRecycler.adapter=adapter
                }
                catch (ex:java.lang.Exception){
                    ex.printStackTrace()
                }
            }

            override fun onFailure(call: Call<ApiResponseProduct>, t: Throwable) {
                Log.e("Failed", "Api Failed" + t.message)
            }
        }
        )
    }
}