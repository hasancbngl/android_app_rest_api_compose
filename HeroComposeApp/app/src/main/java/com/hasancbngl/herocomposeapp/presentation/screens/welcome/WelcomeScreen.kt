package com.hasancbngl.herocomposeapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hasancbngl.herocomposeapp.domain.model.OnBoardingPage
import com.hasancbngl.herocomposeapp.navigation.Screen
import com.hasancbngl.herocomposeapp.presentation.screens.welcome.components.FinishButton
import com.hasancbngl.herocomposeapp.presentation.screens.welcome.components.PagerScreen
import com.hasancbngl.herocomposeapp.ui.theme.EXTRA_LARGE_PADDING
import com.hasancbngl.herocomposeapp.ui.theme.activeIndicatorColor
import com.hasancbngl.herocomposeapp.ui.theme.inactiveIndicatorColor
import com.hasancbngl.herocomposeapp.ui.theme.welcomeScreenBackgroundColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
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
            pageCount = pages.size, state = pagerState,
            verticalAlignment = Alignment.Top,
            modifier = Modifier
                .fillMaxSize()
                .weight(5f)
        ) { index ->
            PagerScreen(page = pages[index])
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(
                    bottom = 24.dp,
                    start = EXTRA_LARGE_PADDING,
                    end = EXTRA_LARGE_PADDING
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(pages.size) { iteration ->
                    val color =
                        if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.activeIndicatorColor
                        else MaterialTheme.colorScheme.inactiveIndicatorColor
                    Box(
                        modifier = Modifier
                            .padding(5.dp)
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)

                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            AnimatedVisibility(visible = pagerState.currentPage == pages.lastIndex) {
                FinishButton {
                    navController.navigate(Screen.Home.route){
                        popUpTo(Screen.Home.route)
                    }
                    welcomeViewModel.saveOnBoardingState(true)
                }
            }
        }
    }
}