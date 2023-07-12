package com.hasancbngl.herocomposeapp.presentation.common

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.presentation.common.components.HeroItem

@Composable
fun ListContent(
    allHeroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {
    LazyColumn{

    }
}