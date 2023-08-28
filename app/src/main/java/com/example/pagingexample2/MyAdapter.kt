package com.example.pagingexample2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pagingexample2.data.Data
import com.example.pagingexample2.new_data.NewItems

class MyAdapter : PagingDataAdapter<NewItems, MyAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<NewItems>(){
            override fun areItemsTheSame(oldItem: NewItems, newItem: NewItems): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: NewItems, newItem: NewItems): Boolean {
                return oldItem == newItem
            }
        }
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val imgArea = view.findViewById<ImageView>(R.id.imgArea)
        val textArea = view.findViewById<TextView>(R.id.textArea)

        fun bind(item : NewItems) {
            textArea.text = item.id.toString()
            imgArea.load(item.owner.avatar_url)
        }

    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        if(item != null) {
            holder.bind(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return MyViewHolder(view)
    }
}