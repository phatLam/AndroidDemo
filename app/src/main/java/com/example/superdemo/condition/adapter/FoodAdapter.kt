package com.example.superdemo.condition.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superdemo.databinding.FoodItemBinding

class FoodAdapter: RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    val list = mutableListOf<String>()
    inner class FoodViewHolder(val binding: FoodItemBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(data: String){
            binding.data = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = FoodItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}