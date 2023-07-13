package com.hasancbngl.herocomposeapp.presentation.common

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.presentation.common.components.HeroItem
import com.hasancbngl.herocomposeapp.presentation.common.components.ShimmerEffect
import com.hasancbngl.herocomposeapp.ui.theme.SMALL_PADDING

@Composable
fun ListContent(
    allHeroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {
    val result = handlePagingResult(allHeroes)

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
fun handlePagingResult(heroes: LazyPagingItems<Hero>): Boolean {
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }

            error != null -> false
            else -> true
        }
    }
}