package com.example.daerah_indonesia_app.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daerah_indonesia_app.R
import com.example.daerah_indonesia_app.model.Daerah
import kotlinx.android.synthetic.main.item_provinsi.view.*

class ProvinsiAdapter(var data: ArrayList<Daerah>?) :RecyclerView.Adapter<ProvinsiAdapter.ProvinsiHolder>() {
    class ProvinsiHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val id = itemView.itemId
        val provinsi = itemView.itemProvinsi
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProvinsiHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_provinsi,parent,false)
        val holder = ProvinsiHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProvinsiHolder, position: Int) {
        holder.provinsi.text = data?.get(position)?.nama
        holder.id.text = data?.get(position)?.id
    }

    override fun getItemCount(): Int {
        return data?.size ?: 0
    }
}