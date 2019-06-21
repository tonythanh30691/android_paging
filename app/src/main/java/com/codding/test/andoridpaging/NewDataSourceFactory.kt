package com.codding.test.andoridpaging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource


class NewDataSourceFactory (private val networkService: NetworkService) : DataSource.Factory <Int, News>() {

    val newsDataSourceLiveData = MutableLiveData<NewDataSource>()

    override fun create(): DataSource<Int, News> {
        val newDataSource = NewDataSource(networkService)
        newsDataSourceLiveData.postValue(newDataSource)
        return newDataSource
    }
}