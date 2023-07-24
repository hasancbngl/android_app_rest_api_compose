package com.hasancbngl.herocomposeapp.presentation.screens.details.components

import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetState
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.ui.theme.MIN_SHEET_HEIGHT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsContent(navController: NavHostController, hero: Hero) {
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = MIN_SHEET_HEIGHT,
        sheetContent = {
            BottomSheetContent(hero = hero)
        }
    ) {

    }
}
