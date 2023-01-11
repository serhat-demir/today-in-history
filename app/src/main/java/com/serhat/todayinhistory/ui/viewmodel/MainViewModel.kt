package com.serhat.todayinhistory.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.serhat.todayinhistory.data.repository.TodayInHistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repo: TodayInHistoryRepository): ViewModel() {
    val articles = repo.articles
    val messageId = repo.messageId

    fun loadData() {
        repo.loadData()
    }
}