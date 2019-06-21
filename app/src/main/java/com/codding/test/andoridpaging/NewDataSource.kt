package com.codding.test.andoridpaging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class NewDataSource (private val networkService: NetworkService) : PageKeyedDataSource<Int, News>() {
    var state : MutableLiveData<State> = MutableLiveData()

    var cocoutinesScope = CoroutineScope(Dispatchers.IO)

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, News>) {
        updateState(State.LOADING)
        cocoutinesScope.launch {
            try {
                var result = networkService.getNews(1, params.requestedLoadSize).await()
                if (result.isSuccessful) {
                    var news = result.body()!!.news
                    updateState(State.DONE)
                    callback.onResult(news, 1, 2)
                } else {
                    updateState(State.ERROR)
                }

            } catch (ex : Exception) {
                updateState(State.ERROR)
            }
        }
    }

    fun updateState(newState : State) {
        state.postValue(newState)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {
        updateState(State.LOADING)
        cocoutinesScope.launch {
            try {
                var result = networkService.getNews(params.key, params.requestedLoadSize).await()
                if (result.isSuccessful) {
                    var news = result.body()!!.news
                    updateState(State.DONE)
                    callback.onResult(news, params.key + 1)
                } else {
                    updateState(State.ERROR)
                }

            } catch (ex : Exception) {
                updateState(State.ERROR)
            }
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, News>) {
    }


}