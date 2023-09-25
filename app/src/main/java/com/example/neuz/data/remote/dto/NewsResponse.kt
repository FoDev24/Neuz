package com.example.neuz.data.remote.dto

import com.example.neuz.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)