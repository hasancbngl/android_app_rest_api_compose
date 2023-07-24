package com.hasancbngl.herocomposeapp.presentation.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hasancbngl.herocomposeapp.ui.theme.SMALL_PADDING
import com.hasancbngl.herocomposeapp.ui.theme.titleColor

@Composable
fun OrderedList(
    title: String,
    items: List<String>,
    textColor: Color
) {
    Column {
        Text(
            modifier = Modifier.padding(bottom = SMALL_PADDING),
            text = title,
            color = textColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        items.forEachIndexed { index, item ->
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = "${index + 1}. $item",
                color = textColor,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun OrderedListPreview() {
    OrderedList(
        title = "Family",
        items = listOf("Minato", "Kushina"),
        textColor = MaterialTheme.colorScheme.titleColor
    )
}

@Composable
@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
fun OrderedListDarkPreview() {
    OrderedList(
        title = "Family",
        items = listOf("Minato", "Kushina"),
        textColor = MaterialTheme.colorScheme.titleColor
    )
}