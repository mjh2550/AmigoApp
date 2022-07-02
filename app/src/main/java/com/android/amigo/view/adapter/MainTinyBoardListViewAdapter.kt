package com.android.amigo.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.amigo.R
import com.android.amigo.view.adapter.MainTinyBoardListViewAdapter.ViewHolder

class MainTinyBoardListViewAdapter(private val context: Context,private val list: java.util.ArrayList<String>)
    : RecyclerView.Adapter<ViewHolder>()
{

//    private var data = list

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
//        var view: View = v.findViewById(R.id.)
        var textView :TextView = v.findViewById(R.id.list_tv_01)
        fun bind(str : String){
            textView.text = str
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val vh = LayoutInflater.from(context).inflate(R.layout.main_tiny_list_item,parent,false)
        return ViewHolder(vh)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount() : Int = list.size
}