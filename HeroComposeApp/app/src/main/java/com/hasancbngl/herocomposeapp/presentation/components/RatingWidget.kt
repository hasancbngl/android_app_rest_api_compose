package com.hasancbngl.herocomposeapp.presentation.components

import FilledStar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.hasancbngl.herocomposeapp.R

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double
) {
    val starPathString = stringResource(id = R.string.star_path)
    //convert star path string to path object
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    FilledStar(starPath = starPath, starPathBounds = starPathBounds)
}

@Preview(showBackground = true)
@Composable
fun RatingWidget() {
    RatingWidget(modifier = Modifier, rating = 2.5)
}