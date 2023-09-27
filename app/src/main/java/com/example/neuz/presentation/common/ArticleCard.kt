package com.example.neuz.presentation.common

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.neuz.domain.model.Article
import com.example.neuz.presentation.Dimens.articleCardSize
import com.example.neuz.presentation.Dimens.extraSmallPadding
import com.example.neuz.R
import com.example.neuz.presentation.Dimens.extraSmallPadding2
import com.example.neuz.presentation.Dimens.smallIconSize


@Composable
fun ArticleCard(
    modifier: Modifier = Modifier, article: Article, onClick: () -> Unit
) {

    val context = LocalContext.current
    Row(modifier = modifier.clickable { onClick() }) {

        AsyncImage(
            modifier = Modifier
                .clip(MaterialTheme.shapes.medium)
                .size(articleCardSize),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .padding(horizontal = extraSmallPadding)
                .height(articleCardSize)
        ) {

            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(id = R.color.text_title),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(verticalAlignment = Alignment.CenterVertically) {

                Text(
                    text = article.source.name,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),

                    )

                Spacer(modifier = Modifier.width(extraSmallPadding2))

                Icon(
                    painter = painterResource(id = R.drawable.ic_time),
                    contentDescription =null ,
                    modifier = Modifier.size(smallIconSize) ,
                    tint = colorResource(id = R.color.body)
                )

                Spacer(modifier = Modifier.width(extraSmallPadding2))

                Text(
                    text = article.publishedAt,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Bold),
                    color = colorResource(id = R.color.body),

                    )


            }
        }


    }
}