package com.example.neuz.di

import android.app.Application
import com.example.neuz.data.manager.LocalUserManagerImp
import com.example.neuz.data.remote.NewsApi
import com.example.neuz.data.repository.NewsRepositoryImp
import com.example.neuz.domain.manager.LocalUserManager
import com.example.neuz.domain.repository.NewsRepository
import com.example.neuz.domain.usecases.app_entry.AppEntryUseCases
import com.example.neuz.domain.usecases.app_entry.ReadAppEntry
import com.example.neuz.domain.usecases.app_entry.SaveAppEntry
import com.example.neuz.domain.usecases.news.GetNews
import com.example.neuz.domain.usecases.news.NewsUseCases
import com.example.neuz.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application : Application
    ) : LocalUserManager = LocalUserManagerImp(application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManager: LocalUserManager
    ) = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi() : NewsApi {
       return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImp(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ) : NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository)
        )
    }







}