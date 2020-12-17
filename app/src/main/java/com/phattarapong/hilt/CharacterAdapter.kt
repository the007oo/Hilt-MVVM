package com.phattarapong.hilt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.phattarapong.hilt.database.CharacterLocal

class CharacterAdapter(var dataList: List<CharacterLocal> = arrayListOf()) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var callBack: ((CharacterLocal) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
    )

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(dataList[position])
        holder.itemView.setOnClickListener {
            callBack?.let{
                it.invoke(dataList[position])
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)
        val nameTextView = itemView.findViewById<TextView>(R.id.nameTextView)

        fun bindData(characterLocal: CharacterLocal){
            Glide.with(itemView.context)
                .load(characterLocal.image)
                .into(imageView)

            nameTextView.text = characterLocal.name
        }
    }
}