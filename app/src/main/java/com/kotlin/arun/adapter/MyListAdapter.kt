package com.kotlin.arun.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.arun.bean.User2

import com.kotlin.arun.databinding.ListItemBinding

/**
 * Created by wy on 2017/6/15.
 */

class MyListAdapter(private val list: List<User2>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemHolder) {
            holder.setData(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class ItemHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var binding: ListItemBinding? = null

        init {
            this.binding = binding
        }

        fun setData(user: User2) {
            binding!!.user = user
        }
    }

}
