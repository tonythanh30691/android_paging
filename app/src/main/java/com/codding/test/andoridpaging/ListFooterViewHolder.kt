package com.codding.test.andoridpaging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_footer.view.*

class ListFooterViewHolder (view: View) : RecyclerView.ViewHolder  (view) {
    fun bind(status: State) {
        itemView.progress_bar.visibility = if (status == State.LOADING) View.VISIBLE else View.GONE
        itemView.txt_error.visibility = if (status == State.ERROR) View.VISIBLE else View.INVISIBLE
    }

    companion object {
        fun create(parent: ViewGroup) : ListFooterViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_footer, parent, false)
            return ListFooterViewHolder(view)
        }
    }
}