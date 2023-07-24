package com.hasancbngl.herocomposeapp.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hasancbngl.herocomposeapp.navigation.Screen
import com.hasancbngl.herocomposeapp.presentation.common.ListContent
import com.hasancbngl.herocomposeapp.presentation.screens.home.components.HomeScreenTopBar

@Composable
fun HomeScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = viewModel.getAllHeroes.collectAsLazyPagingItems()
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