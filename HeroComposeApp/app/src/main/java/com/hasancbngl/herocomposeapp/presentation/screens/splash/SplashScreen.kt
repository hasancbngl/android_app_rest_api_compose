package com.hasancbngl.herocomposeapp.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationVector1D
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.ui.theme.Purple40
import com.hasancbngl.herocomposeapp.ui.theme.Purple80

@Composable
fun SplashScreen(navController: NavHostController) {
    val degrees = remember {
        Animatable(0f)
    }

    Splash(degrees.value)

    LaunchedEffect(key1 = "") {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 2000,
                delayMillis = 200
            )
        )
    }
}

@Composable
fun Splash(degrees: Float) {
    val modifier = if (isSystemInDarkTheme()) Modifier
        .fillMaxSize()
        .background(Color.Black)
    else Modifier
        .fillMaxSize()
        .background(
            Brush.verticalGradient(
                listOf(
                    Purple80,
                    Purple40
                )
            )
        )


    Box(
        modifier =modifier,
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = R.drawable.ic_logo,
            contentDescription = stringResource(id = R.string.icon),
            modifier = Modifier
                .rotate(degrees)
                .size(125.dp)
        )
    }
}

@Preview
@Composable
fun SplashScreenPreView() {
    Splash(0f)
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun SplashScreenDarkPreView() {
    Splash(0f)
}