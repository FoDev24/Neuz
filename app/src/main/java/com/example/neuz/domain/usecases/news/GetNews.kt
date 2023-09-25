package com.example.neuz.domain.usecases.news

import androidx.paging.PagingData
import com.example.neuz.domain.model.Article
import com.example.neuz.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources : List<String>) : Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}