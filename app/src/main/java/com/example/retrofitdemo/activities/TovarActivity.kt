package com.example.retrofitdemo.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.retrofitdemo.databinding.ActivityMainBinding
import com.example.retrofitdemo.databinding.TovarMainBinding
import com.example.retrofitdemo.model.Category.Categories
import com.example.retrofitdemo.model.Product.Product

class TovarActivity : AppCompatActivity()
{
    private lateinit var binding: TovarMainBinding

    var categoryList = ArrayList<Categories>()
    var productList = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TovarMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}