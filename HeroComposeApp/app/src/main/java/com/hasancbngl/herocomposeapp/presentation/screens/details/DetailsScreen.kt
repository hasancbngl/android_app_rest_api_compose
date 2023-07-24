package com.hasancbngl.herocomposeapp.presentation.screens.details

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.presentation.screens.details.components.DetailsContent

@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val hero by detailsViewModel.selectedHero.collectAsState()

    Log.e("TAG", "DetailsScreen: $hero", )

    hero?.let { DetailsContent(navController, it) }

}