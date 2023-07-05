package com.example.myappfinal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappfinal.databinding.ItemViewBinding

class FeedRecyclerViewAdapter(val dataList : MutableList<Post>) : RecyclerView.Adapter<FeedRecyclerViewAdapter.HomeRecyclerViewViewHolder>()  {

    inner class HomeRecyclerViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val binding = ItemViewBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRecyclerViewViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return HomeRecyclerViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeRecyclerViewViewHolder, position: Int) {
        val item = dataList[position]
        holder.binding.apply {
            emailAuthorTV.text = item.name
            emailSubjectTV.text = item.subject
            emailContentTV.text = item.content
//            imageView.setImageResource(item.image!!)
        }
    }

    override fun getItemCount() = dataList.size
}