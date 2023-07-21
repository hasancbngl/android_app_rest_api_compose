package com.hasancbngl.herocomposeapp.presentation.screens.search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.hasancbngl.herocomposeapp.presentation.common.ListContent
import com.hasancbngl.herocomposeapp.presentation.screens.search.components.SearchTopBar
import org.w3c.dom.Text

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery = searchViewModel.searchQuery.value
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()

    Scaffold(topBar = {
        SearchTopBar(
            text = searchQuery,
            onTextChange = {
                searchViewModel.updateSearchQuery(it)
            },
            onCloseClicked = {
                navController.popBackStack()
            },
            onSearchClicked = {
                searchViewModel.searchHeroes(it)
            }
        )
    }) { contentPadding ->
        Box(modifier = Modifier.padding(contentPadding)) {
            ListContent(heroes, navController)
        }
    }
}