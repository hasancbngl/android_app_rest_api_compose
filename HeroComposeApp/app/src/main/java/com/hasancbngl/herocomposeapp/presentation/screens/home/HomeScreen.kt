package com.hasancbngl.herocomposeapp.presentation.screens.home

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hasancbngl.herocomposeapp.presentation.screens.home.components.HomeScreenTopBar

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            HomeScreenTopBar {

            }
        },
        content = {
            it
        }
    )
}