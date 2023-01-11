package com.serhat.todayinhistory.data.retrofit

import com.serhat.todayinhistory.data.model.TodayInHistory
import io.reactivex.Single
import retrofit2.http.GET

interface ApiInterface {
    @GET("tarihtebugun/")
    fun getTodayInHistory(): Single<TodayInHistory>
}