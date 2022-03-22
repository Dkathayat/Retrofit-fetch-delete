package com.kathayat.login

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecylerViewAdapater:RecyclerView.Adapter<RecylerViewAdapater.MyviewHolder>() {

    var userList = mutableListOf<User>()

    class MyviewHolder(view: View):RecyclerView.ViewHolder(view) {

        val textViewName = view.findViewById<TextView>(R.id.textViewName)
        val textViewEmail = view.findViewById<TextView>(R.id.textViewEmail)
        val textViewstats = view.findViewById<TextView>(R.id.textViewStats)

        fun bind(data: User) {

            textViewName.text = data.name
            textViewEmail.text = data.email
            textViewstats.text = data.status

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        return MyviewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item,parent,false))
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.bind(userList[position])
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}