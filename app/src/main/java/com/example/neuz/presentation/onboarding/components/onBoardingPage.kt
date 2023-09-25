package com.example.neuz.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.neuz.presentation.Dimens.mediumPadding1
import com.example.neuz.presentation.Dimens.mediumPadding2
import com.example.neuz.presentation.onboarding.Page
import com.example.neuz.R
import com.example.neuz.presentation.onboarding.pages
import com.example.neuz.ui.theme.NeuzTheme



@Composable
fun OnBoarding(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(mediumPadding1))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal= mediumPadding2),
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = mediumPadding2),
            style = MaterialTheme.typography.bodyMedium,
            color = colorResource(id = R.color.text_medium
            )
        )

    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES , showBackground = true)
@Composable
fun OnBoardingPagePreview(){
    NeuzTheme() {
        OnBoarding(page =
        pages[0]
        )
    }
}
