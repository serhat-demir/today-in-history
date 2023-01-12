package com.serhat.todayinhistory.di

import com.serhat.todayinhistory.data.repository.TodayInHistoryRepository
import com.serhat.todayinhistory.data.retrofit.ApiClient
import com.serhat.todayinhistory.data.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTodayInHistoryRepository(apiService: ApiInterface): TodayInHistoryRepository {
        return TodayInHistoryRepository(apiService)
    }

    @Provides
    @Singleton
    fun provideApiService(): ApiInterface {
        return ApiClient.getService()
    }
}