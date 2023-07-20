package com.hasancbngl.herocomposeapp.presentation.screens.home.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.ui.theme.topAppBarBackgroundColor
import com.hasancbngl.herocomposeapp.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(onSearchClick: () -> Unit) {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.topAppBarBackgroundColor),
        actions = {
            Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween) {
                Text(
                    text = stringResource(id = R.string.explore),
                    color = MaterialTheme.colorScheme.topAppBarContentColor,
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 16.dp,
                    top = 12.dp)
                )
                IconButton(onClick = onSearchClick) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_icon),
                    )
                }
            }
        }
    )
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeScreenTopBar {}
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HomeTopBarDarkPreview() {
    HomeScreenTopBar {}
}