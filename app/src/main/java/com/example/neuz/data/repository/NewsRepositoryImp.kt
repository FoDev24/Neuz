package com.example.neuz.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.neuz.data.remote.NewsApi
import com.example.neuz.data.remote.NewsPagingSource
import com.example.neuz.domain.model.Article
import com.example.neuz.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImp(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi = newsApi,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }
}