package com.dicoding.kostracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListKostAdapter(private val listKost: ArrayList<Kost>, private val onItemClick: (Kost) -> Unit) : RecyclerView.Adapter<ListKostAdapter.ListViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_kost, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, facility, photo, price) = listKost[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvFacility.text = facility
        holder.tvPrice.text = price

        holder.itemView.setOnClickListener { onItemClick.invoke(listKost[position]) } //kode baru
    }

    override fun getItemCount(): Int = listKost.size

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvFacility: TextView = itemView.findViewById(R.id.tv_item_facility)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
    }
}