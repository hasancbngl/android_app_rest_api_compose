package com.hasancbngl.herocomposeapp.presentation.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.navigation.Screen
import com.hasancbngl.herocomposeapp.presentation.common.components.HeroItem
import com.hasancbngl.herocomposeapp.presentation.common.components.ShimmerEffect
import com.hasancbngl.herocomposeapp.presentation.common.layout_error.ErrorScreen
import com.hasancbngl.herocomposeapp.ui.theme.SMALL_PADDING

@Composable
fun ListContent(
    allHeroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {
    val currentRoute = navController.currentBackStackEntry?.destination?.route
    val isAtHomeScreen = currentRoute == Screen.Home.route
    val result = handlePagingResult(allHeroes, isAtHomeScreen)

    if (result) LazyColumn(
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(allHeroes.itemCount) {
            allHeroes[it]?.let { it1 -> HeroItem(hero = it1, navController = navController) }
        }
    }
}

@Composable
fun handlePagingResult(heroes: LazyPagingItems<Hero>, showShimmerEffect: Boolean): Boolean {
    heroes.apply {

        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }
        Log.e("TAG", "handlePagingResult: ${heroes.itemCount}")
        return when {
            loadState.refresh is LoadState.Loading -> {
                if (showShimmerEffect) ShimmerEffect()
                else ErrorScreen()
                false
            }

            error != null -> {
                ErrorScreen(error = error, heroes = heroes)
                false
            }

            heroes.itemCount < 1 -> {
                ErrorScreen()
                false
            }

            else -> true
        }
    }
}