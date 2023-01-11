package com.serhat.todayinhistory.data.model

import com.google.gson.annotations.SerializedName

class TodayInHistory(
    @SerializedName("success")
    var success: Boolean,
    @SerializedName("status")
    var status: String,
    @SerializedName("pagecreatedate")
    var pageCreateDate: String,
    @SerializedName("tarihtebugun")
    var articles: ArrayList<Article>
)