package com.example.retrofitdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.Category.Categories
import com.example.retrofitdemo.model.Product.Product
import com.squareup.picasso.Picasso

class ProductsAdapter(private val mlist:List<Product>):
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View): RecyclerView.ViewHolder(ItemView){
        val productButton: Button = ItemView.findViewById(R.id.productButton)
        val productTextView: TextView = ItemView.findViewById(R.id.productTextView)
        val productImage: ImageView = ItemView.findViewById(R.id.productImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.productrecycler_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val products=mlist[position]
        holder.productButton.text=products.price.toString()
        holder.productTextView.text=products.description
        Picasso.get().load( "http://172.30.44.151:8090/images/product/"+products.image).into(holder.productImage)
    }
}