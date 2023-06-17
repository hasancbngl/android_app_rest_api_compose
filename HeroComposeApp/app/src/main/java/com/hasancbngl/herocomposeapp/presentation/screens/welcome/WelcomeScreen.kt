package com.hasancbngl.herocomposeapp.presentation.screens.welcome

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.hasancbngl.herocomposeapp.domain.model.OnBoardingPage
import com.hasancbngl.herocomposeapp.ui.theme.welcomeScreenBackgroundColor
import com.hasancbngl.herocomposeapp.util.Constants.ON_BOARDING_PAGE_COUNT

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(navController: NavHostController) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third,
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.welcomeScreenBackgroundColor)
    ) {
        HorizontalPager(
            pageCount = ON_BOARDING_PAGE_COUNT, state = pagerState,
            verticalAlignment = Alignment.Top
        ) { page ->
            PagerScreen(page = pages[page])
        }
    }
}

@Composable
fun PagerScreen(page: OnBoardingPage) {

}