package com.simsekselim.multiplebackstacks.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.simsekselim.multiplebackstacks.R
import kotlinx.coroutines.flow.MutableStateFlow

/**
 * @Author: Selim Simsek
 * @Date: 16.10.2023
 */
class HomeAdapter(private val data: List<Int>): RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    var onItemClicked: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return HomeViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(data[position])
    }

    inner class HomeViewHolder(val item: View): RecyclerView.ViewHolder(item){
        fun bind(data: Int){
            val title = item.findViewById<TextView>(R.id.counter)
            title.text = data.toString()
            itemView.setOnClickListener {
                onItemClicked?.invoke(data)
            }
        }
    }

}