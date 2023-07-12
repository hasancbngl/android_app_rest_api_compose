package com.hasancbngl.herocomposeapp.presentation.screens.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hasancbngl.herocomposeapp.presentation.screens.home.components.HomeScreenTopBar
import com.hasancbngl.herocomposeapp.presentation.common.ListContent

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeScreenTopBar {

            }
        }
    ) { contentPadding ->
        ListContent(allHeroes,navController)
    }
}