package com.codding.test.andoridpaging

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("users")
    fun getNews(
        @Query("page") page: Int,
        @Query("pagesize") pageSize : Int,
        @Query("site") site : String = "stackoverflow")
            : Deferred<Response<NewsResponse>>

    companion object {
        fun getService() : NetworkService {
            val retrofix = Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/2.2/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofix.create(NetworkService::class.java)
        }
    }


}