package com.hasancbngl.herocomposeapp.presentation.screens.search

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hasancbngl.herocomposeapp.presentation.screens.search.components.SearchTopBar
import org.w3c.dom.Text

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery = searchViewModel.searchQuery.value

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

            }
        )
    }) { contentPadding ->

    }
}