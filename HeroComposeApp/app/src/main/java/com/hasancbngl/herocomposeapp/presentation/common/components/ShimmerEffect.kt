package com.hasancbngl.herocomposeapp.presentation.common.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.hasancbngl.herocomposeapp.ui.theme.LARGE_PADDING
import com.hasancbngl.herocomposeapp.ui.theme.SMALL_PADDING

@Composable
fun ShimmerEffect() {
    LazyColumn(
        modifier = Modifier.padding(top = LARGE_PADDING),
        contentPadding = PaddingValues(SMALL_PADDING),
        verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
    ) {
        items(2) {
            AnimatedShimmerItem()
        }
    }
}