package com.example.retrofitdemo.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitdemo.R
import com.example.retrofitdemo.model.Category.Categories

class CategoriesAdapter(private val mlist:List<Categories>):
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val buttonCategories: Button = ItemView.findViewById(R.id.Button_Categories)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.categories_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categories=mlist[position]
        holder.buttonCategories.setText(categories.category)
    }
}