package com.codding.test.andoridpaging

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList

class NewViewModal : ViewModel() {
    private val networkService  = NetworkService.getService()

    var newsList : LiveData<PagedList<News>>
    private val pageSize = 50
    private val newDataSourceFactory : NewDataSourceFactory

    init {
        newDataSourceFactory = NewDataSourceFactory(networkService)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setEnablePlaceholders(true)
            .setPrefetchDistance(30)
            .build()
        newsList = LivePagedListBuilder<Int, News>(newDataSourceFactory, config).build()

    }

}