package com.codding.test.andoridpaging

import com.google.gson.annotations.SerializedName

data class News (@SerializedName("display_name") val title: String, @SerializedName("profile_image") val image : String)