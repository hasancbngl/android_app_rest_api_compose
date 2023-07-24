package com.hasancbngl.herocomposeapp.presentation.screens.details.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.ui.theme.MEDIUM_PADDING

@Composable
fun BottomSheetAbout(about: String, contentColor: Color) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(R.string.about),
        color = contentColor,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
    Text(
        modifier = Modifier
            .alpha(ContentAlpha.medium)
            .padding(bottom = MEDIUM_PADDING),
        text = about,
        color = contentColor,
        fontSize = 16.sp,
        maxLines = 7
    )
}