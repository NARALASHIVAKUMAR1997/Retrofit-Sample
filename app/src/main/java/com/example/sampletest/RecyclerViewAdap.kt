package com.example.sampletest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.replies_child_layout.view.*
import kotlinx.android.synthetic.main.sample_layout.*
import kotlinx.android.synthetic.main.sample_layout.view.*

class RecyclerViewAdap(val context: Context, val list: List<Example>) :
    RecyclerView.Adapter<RecyclerViewAdap.MYViewHolder>() {

    inner class MYViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        var userName = view.username
        var display_name = view.display_name
        var posted_ago = view.posted_ago
        var text = view.text
        var likes = view.likes
        var postes = view.postes
        var shares = view.shares
        var replies = view.replies_1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MYViewHolder {
        return MYViewHolder(
            LayoutInflater.from(context).inflate(R.layout.replies_child_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MYViewHolder, position: Int) {
        val example = list[position]
        holder.userName.text = example.username
        holder.display_name.text = example.displayname
        holder.posted_ago.text = example.postedAt
        holder.text.text = example.text
        holder.likes.text = example.likes.toString()
        holder.postes.text = example.postLevel.toString()
        holder.shares.text = example.shares.toString()
        holder.replies.apply {
            layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
           if (adapter==null){
               adapter = RecyclerViewAdapChild(context, example.replies)
           }
        }
    }

    override fun getItemCount(): Int = list.size
}