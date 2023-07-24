package com.hasancbngl.herocomposeapp.presentation.common.layout_error

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.domain.model.Hero
import java.net.ConnectException
import java.net.SocketTimeoutException

@Composable
fun ErrorScreen(
    error: LoadState.Error? = null,
    heroes: LazyPagingItems<Hero>? = null
) {

    var message by remember {
        mutableStateOf("Find your Favorite Hero!")
    }
    var icon by remember {
        mutableStateOf(R.drawable.ic_search_document)
    }
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim by animateFloatAsState(
        targetValue = if (startAnimation) .38f else 0f,
        animationSpec = tween(
            durationMillis = 1000
        )
    )

    if (error != null) {
        message = stringResource(R.string.please_check_your_internet_connection)
        icon = R.drawable.ic_network_error
    }

    LaunchedEffect(key1 = true) {
        startAnimation = true
    }

    EmptyContent(
        alphaAnim = alphaAnim,
        icon = icon,
        message = message,
        heroes = heroes,
        error = error
    )
}

@Preview(showSystemUi = true)
@Composable
fun ErrorScreenPreview() {
    ErrorScreen(error = LoadState.Error(SocketTimeoutException()))
}

@Preview(
    uiMode = UI_MODE_NIGHT_YES,
    showSystemUi = true
)
@Composable
fun ErrorScreenDarkPreview() {
    ErrorScreen(error = LoadState.Error(ConnectException()))
}