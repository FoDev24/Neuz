package com.example.neuz.presentation.common

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.neuz.domain.model.Article
import com.example.neuz.presentation.Dimens.extraSmallPadding
import com.example.neuz.presentation.Dimens.extraSmallPadding2
import com.example.neuz.presentation.Dimens.mediumPadding1
import com.example.neuz.presentation.Dimens.mediumPadding2

@Composable
fun ArticlesList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {
    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(mediumPadding1),
            contentPadding = PaddingValues(all = extraSmallPadding2)
        ) {
            items(count = articles.itemCount){
                articles[it]?.let {
                    ArticleCard(article = it, onClick = {onClick(it)})
                }
                }
            }
        }
    }



@Composable
fun handlePagingResult(
    articles: LazyPagingItems<Article>,
): Boolean {

    val loadState = articles.loadState
    val error = when {
        loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
        loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
        loadState.append is LoadState.Error -> loadState.append as LoadState.Error
        else -> null
    }
    return when {
        loadState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }
        error != null -> {
            EmptyScreen()
            false
        }
        else -> {
            true
        }
    }
}

@Composable
private fun ShimmerEffect() {
    Column(verticalArrangement = Arrangement.spacedBy(mediumPadding1)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = mediumPadding2)
            )
        }
    }
}