package com.codding.test.andoridpaging

import com.google.gson.annotations.SerializedName

data class NewsResponse (@SerializedName("items") val news: List<News>)