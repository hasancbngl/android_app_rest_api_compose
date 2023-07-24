package com.hasancbngl.herocomposeapp.presentation.screens.details.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.ui.theme.INFO_ICON_SIZE
import com.hasancbngl.herocomposeapp.ui.theme.LARGE_PADDING

@Composable
fun BottomSheetIconAndTitle(name: String, contentColor: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = LARGE_PADDING),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(INFO_ICON_SIZE)
                .weight(2f),
            painter = painterResource(id = R.drawable.ic_logo),
            contentDescription = "",
            tint = contentColor
        )
        Text(
            modifier = Modifier
                .weight(8f),
            text = name,
            color = contentColor,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}