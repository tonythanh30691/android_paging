package com.codding.test.andoridpaging

import android.os.AsyncTask
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class NewListAdapter : PagedListAdapter<News, NewsViewHolder>(NewsDiffCallBack) {


    private var state = State.LOADING

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.create(parent)
    }


    companion object {
        val NewsDiffCallBack = object : DiffUtil.ItemCallback <News>() {
            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem.title == newItem.title
            }
        }

    }

    override fun getItemCount(): Int {
        return super.getItemCount()
    }


}