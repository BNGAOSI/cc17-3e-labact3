package com.ambiongltb.fulldashboardededdneddy.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ambiongltb.fulldashboardededdneddy.R
import com.ambiongltb.fulldashboardededdneddy.model.ResidentModel

class ResAdapter (private val resList: ArrayList<ResidentModel>) : RecyclerView.Adapter<ResAdapter.ViewHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(clickListener: onItemClickListener){
        mListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.rep_list_item, parent, false)
        return ViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentRep = resList[position]
        holder.tvResName.text = currentRep.resName
    }



    override fun getItemCount(): Int {
        return resList.size
    }

    class ViewHolder( itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {

        val tvResName : TextView = itemView.findViewById(R.id.tvResName)

        init {
            itemView.setOnClickListener {
                clickListener.onItemClick(adapterPosition)
            }
        }

    }

}