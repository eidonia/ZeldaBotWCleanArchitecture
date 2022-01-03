package com.example.zeldabotwcleanarchitecture.ui.monster_list

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.zeldabotwcleanarchitecture.R
import com.example.zeldabotwcleanarchitecture.domain.model.MonsterDetail

class MonsterListAdapter constructor(private val context: Context, private val callBack: OnClickCallBack): RecyclerView.Adapter<MonsterListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        val imageMonster: ImageView = itemView.findViewById(R.id.img_monster)
        val txtNameMonster: TextView = itemView.findViewById(R.id.txt_monster)
    }

    private var listMonster = mutableListOf<MonsterDetail>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.monster_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val monster = listMonster[position]
        holder.txtNameMonster.text = monster.name
        Glide.with(context)
            .load(monster.image)
            .into(holder.imageMonster)
        holder.itemView.setOnClickListener {
            callBack.detailMonster(monsterId = monster.id)
        }
    }

    override fun getItemCount(): Int {
        return listMonster.size
    }

    fun addMonster(listApiMonster: List<MonsterDetail>) {
        Log.e("blopAdapter", listApiMonster[0].toString())
        listMonster.addAll(listApiMonster)
        Log.e("blopAdapter", listMonster[0].toString())
    }

    interface OnClickCallBack {
        fun detailMonster(monsterId: Int)
    }
}