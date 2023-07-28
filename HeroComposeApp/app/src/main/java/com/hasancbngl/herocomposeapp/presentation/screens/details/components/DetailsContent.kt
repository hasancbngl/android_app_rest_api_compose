package com.hasancbngl.herocomposeapp.presentation.screens.details.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.BottomSheetScaffoldState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.ui.theme.LARGE_PADDING
import com.hasancbngl.herocomposeapp.ui.theme.MIN_SHEET_HEIGHT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsContent(navController: NavHostController, hero: Hero, colors: Map<String, String>) {
    val scaffoldState = rememberBottomSheetScaffoldState()
    val radiusAnim by animateDpAsState(
        targetValue =
        if (scaffoldState.bottomSheetState.currentValue == SheetValue.Expanded) LARGE_PADDING else 0.dp
    )
    var vibrant by remember { mutableStateOf("#000000") }
    var darkVibrant by remember { mutableStateOf("#000000") }
    var onDarkVibrant by remember { mutableStateOf("#ffffff") }
    LaunchedEffect(key1 = hero) {
        vibrant = colors["vibrant"]!!
        darkVibrant = colors["darkVibrant"]!!
        onDarkVibrant = colors["onDarkVibrant"]!!
    }
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(android.graphics.Color.parseColor(darkVibrant))
        )
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetShape = RoundedCornerShape(
            topStart = radiusAnim,
            topEnd = radiusAnim
        ),
        sheetPeekHeight = MIN_SHEET_HEIGHT,
        sheetContent = {
            BottomSheetContent(
                hero = hero,
                infoBoxIconColor = Color(android.graphics.Color.parseColor(vibrant)),
                sheetBackgroundColor = Color(android.graphics.Color.parseColor(darkVibrant)),
                contentColor = Color(android.graphics.Color.parseColor(onDarkVibrant))
            )
        }
    ) {
        BackgroundContent(
            heroImage = hero.image,
            imageFraction = scaffoldState.currentSheetOffset,
            backgroundColor = Color(android.graphics.Color.parseColor(darkVibrant)),
        ) {
            navController.popBackStack()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
val BottomSheetScaffoldState.currentSheetOffset: Float
    get() {
        val offset = bottomSheetState.requireOffset()
        val targetValue = bottomSheetState.targetValue
        val currentValue = bottomSheetState.currentValue

        return when {
            currentValue == SheetValue.Hidden && targetValue == SheetValue.Hidden -> 1f
            currentValue == SheetValue.Expanded && targetValue == SheetValue.Expanded -> 0f
            else -> offset
        }
    }