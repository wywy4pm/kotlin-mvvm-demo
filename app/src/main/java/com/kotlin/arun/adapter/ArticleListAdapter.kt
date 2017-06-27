package com.kotlin.arun.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView.ViewHolder
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kotlin.arun.bean.ArticleListViewModel
import com.kotlin.arun.databinding.ArticleListItemBinding
import com.kotlin.arun.databindingcomponent.MyComponent

/**
 * Created by wy on 2017/6/23.
 */
class ArticleListAdapter(private val context: Context, private val list: List<ArticleListViewModel>) : Adapter<ViewHolder>() {

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val binding = ArticleListItemBinding.inflate(LayoutInflater.from(context), parent, false, MyComponent())
        return ItemHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (holder is ItemHolder) {
            val itemHolder: ItemHolder = holder
            itemHolder.setData(list[position])
        }
    }

    class ItemHolder(binding: ArticleListItemBinding) : ViewHolder(binding.root) {
        private var binding: ArticleListItemBinding? = null

        init {
            this.binding = binding
        }

        fun setData(viewModel: ArticleListViewModel) {
            binding?.viewModel = viewModel
        }
    }

}