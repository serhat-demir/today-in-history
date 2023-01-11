package com.serhat.todayinhistory.data.repository

import androidx.lifecycle.MutableLiveData
import com.serhat.todayinhistory.R
import com.serhat.todayinhistory.data.model.Article
import com.serhat.todayinhistory.data.model.TodayInHistory
import com.serhat.todayinhistory.data.retrofit.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class TodayInHistoryRepository(private val apiService: ApiInterface) {
    val articles = MutableLiveData<ArrayList<Article>>()
    val messageId = MutableLiveData<Int>()

    private val disposable = CompositeDisposable()

    fun loadData() {
        disposable.add(
            apiService.getTodayInHistory()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object: DisposableSingleObserver<TodayInHistory>() {
                    override fun onSuccess(t: TodayInHistory) {
                        if (t.success) articles.value = t.articles
                        else messageId.value = R.string.msg_content
                    }

                    override fun onError(e: Throwable) {
                        messageId.value = R.string.msg_internet
                    }
                })
        )
    }
}