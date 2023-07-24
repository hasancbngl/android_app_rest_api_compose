package com.hasancbngl.herocomposeapp.presentation.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.presentation.common.components.OrderedList

@Composable
fun BottomSheetLists(hero: Hero, contentColor: Color) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        OrderedList(
            title = stringResource(R.string.family),
            items = hero.family,
            textColor = contentColor
        )
        OrderedList(
            title = stringResource(R.string.abilities),
            items = hero.abilities,
            textColor = contentColor
        )
        OrderedList(
            title = stringResource(R.string.nature_types),
            items = hero.natureTypes,
            textColor = contentColor
        )
    }
}