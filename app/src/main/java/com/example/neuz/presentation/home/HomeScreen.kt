package com.example.neuz.presentation.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import com.example.neuz.R
import com.example.neuz.domain.model.Article
import com.example.neuz.presentation.Dimens.mediumPadding1
import com.example.neuz.presentation.common.ArticlesList
import com.example.neuz.presentation.common.Searchbar
import com.example.neuz.presentation.navgraph.Route

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    articles: LazyPagingItems<Article>,
    navigate: (String) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = "\uD83d\uDFE5") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = mediumPadding1)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_logo), contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(mediumPadding1)
        )

        Spacer(modifier = Modifier.height(mediumPadding1))

        Searchbar(
            modifier = Modifier.padding(horizontal = mediumPadding1),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {
                      navigate(Route.SearchScreen.route)
            },
            onSearch = {}
        )

        Spacer(modifier = Modifier.height(mediumPadding1))
        
        Text(
            text = titles,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = mediumPadding1)
                .basicMarquee() ,
            fontSize = 12.sp,
            color = colorResource(id = R.color.placeholder)
        )

        Spacer(modifier = Modifier.height(mediumPadding1))
        
        ArticlesList(modifier = Modifier.padding(horizontal = mediumPadding1),
            articles =articles ,
            onClick ={
                navigate(Route.DetailsScreen.route)
            } )




    }
}

