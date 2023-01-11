package com.serhat.todayinhistory.data.model

import com.google.gson.annotations.SerializedName

class Article(
    @SerializedName("Gun")
    var day: String,
    @SerializedName("Ay")
    var month: String,
    @SerializedName("Yil")
    var year: String,
    @SerializedName("Durum")
    var type: String,
    @SerializedName("Olay")
    var description: String
)