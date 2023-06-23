package com.hasancbngl.herocomposeapp.presentation.screens.welcome.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.hasancbngl.herocomposeapp.domain.model.OnBoardingPage
import com.hasancbngl.herocomposeapp.ui.theme.EXTRA_LARGE_PADDING
import com.hasancbngl.herocomposeapp.ui.theme.SMALL_PADDING
import com.hasancbngl.herocomposeapp.ui.theme.descriptionColor
import com.hasancbngl.herocomposeapp.ui.theme.titleColor

@Composable
fun PagerScreen(page: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        AsyncImage(
            model = page.imageResource, contentDescription = "",
            modifier = Modifier
                .fillMaxWidth(.5f)
                .fillMaxHeight(.7f)
        )
        Text(
            text = page.title,
            color = MaterialTheme.colorScheme.titleColor,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(SMALL_PADDING))
        Text(
            text = page.description,
            color = MaterialTheme.colorScheme.descriptionColor,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
        )
    }
}