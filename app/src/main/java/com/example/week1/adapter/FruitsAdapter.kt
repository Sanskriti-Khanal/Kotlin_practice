package com.example.week1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week1.R

class FruitsAdapter (
    val context:Context,
    val imagelist:ArrayList<Int>,
    val titleList:ArrayList<String>,
    val descList: ArrayList<String>,
):RecyclerView.Adapter<FruitsAdapter.FruitsViewHolder>()
{
    class FruitsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.imageView3)
        val title : TextView = itemView.findViewById(R.id.title)
        val desc : TextView = itemView.findViewById(R.id.description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitsViewHolder {
        val itemView : View = LayoutInflater.from(context).inflate(R.layout.sample_fruits,parent,false)
       return FruitsViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return imagelist.size

    }

    override fun onBindViewHolder(holder: FruitsViewHolder, position: Int) {
        holder.title.text = titleList[position]
        holder.desc.text = descList[position]
        holder.image.setImageResource(imagelist[position])

    }
}