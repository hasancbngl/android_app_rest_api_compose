package com.hasancbngl.herocomposeapp.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hasancbngl.herocomposeapp.navigation.Screen
import com.hasancbngl.herocomposeapp.presentation.common.ListContent
import com.hasancbngl.herocomposeapp.presentation.screens.home.components.HomeScreenTopBar
import com.hasancbngl.herocomposeapp.ui.theme.topAppBarBackgroundColor

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()
    val systemBarColor = MaterialTheme.colorScheme.topAppBarBackgroundColor
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = systemBarColor
        )
    }
    Scaffold(
        topBar = {
            HomeScreenTopBar {
                navController.navigate(Screen.Search.route)
            }
        }
    ) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)){
        ListContent(allHeroes,navController)
    }}
}