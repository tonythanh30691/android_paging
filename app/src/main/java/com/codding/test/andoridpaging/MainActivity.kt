package com.codding.test.andoridpaging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_news_list.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewViewModal
    private lateinit var newsListAdapter: NewListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_list)
        viewModel = ViewModelProviders.of(this)
            .get(NewViewModal::class.java)
        initAdapter()
        //initState()
    }

    private fun initAdapter() {
        newsListAdapter = NewListAdapter()
        recycler_view.layoutManager  = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_view.adapter = newsListAdapter
        viewModel.newsList.observe(this, Observer {
            newsListAdapter.submitList(it)
        })
    }

//    private fun initState() {
//        viewModel.getState().observe(this, Observer { state ->
//            progress_bar.visibility = if (viewModel.listIsEmpty() && state == State.LOADING) View.VISIBLE else View.GONE
//            txt_error.visibility = if (viewModel.listIsEmpty() && state == State.ERROR) View.VISIBLE else View.GONE
//            if (!viewModel.listIsEmpty()) {
//                newsListAdapter.setState(state ?: State.DONE)
//            }
//        })
//    }
}
