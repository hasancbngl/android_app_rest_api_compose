package com.hasancbngl.herocomposeapp.presentation.common.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.ui.theme.INFO_ICON_SIZE
import com.hasancbngl.herocomposeapp.ui.theme.SMALL_PADDING
import com.hasancbngl.herocomposeapp.ui.theme.titleColor

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .padding(end = SMALL_PADDING)
                .size(INFO_ICON_SIZE),
            painter = icon,
            contentDescription = "",
            tint = iconColor
        )
        Column {
            Text(
                text = bigText,
                color = textColor,
                fontSize = 20.sp,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = smallText,
                color = textColor,
                fontSize = 13.sp
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun InfoBoxPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colorScheme.primary,
        bigText = "92",
        smallText = "Power",
        textColor = MaterialTheme.colorScheme.titleColor
    )
}

@Composable
@Preview(showSystemUi = false, uiMode = UI_MODE_NIGHT_YES)
fun InfoBoxDarkPreview() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_bolt),
        iconColor = MaterialTheme.colorScheme.primary,
        bigText = "92",
        smallText = "Power",
        textColor = MaterialTheme.colorScheme.titleColor
    )
}