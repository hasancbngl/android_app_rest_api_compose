package com.hasancbngl.herocomposeapp.presentation.components

import FilledStar
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.PathParser
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.util.Constants.EMPTY_STARS
import com.hasancbngl.herocomposeapp.util.Constants.FILLED_STARS
import com.hasancbngl.herocomposeapp.util.Constants.HALF_FILLED_STARS

@Composable
fun RatingWidget(
    modifier: Modifier,
    rating: Double,
    starSize:Dp,
    scaleFactor: Float = 2f,
    spaceBetween: Dp = 6.dp,
) {
    val result = calculateStars(rating = rating)

    val starPathString = stringResource(id = R.string.star_path)
    //convert star path string to path object
    val starPath = remember {
        PathParser().parsePathString(starPathString).toPath()
    }
    val starPathBounds = remember {
        starPath.getBounds()
    }
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(spaceBetween)
    ) {
        result[FILLED_STARS]?.let {
            repeat(it) {
                FilledStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor,
                    starSize = starSize
                )
            }
        }
        result[HALF_FILLED_STARS]?.let {
            repeat(it) {
                HalfFilledStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor,
                    starSize = starSize
                )
            }
        }
        result[EMPTY_STARS]?.let {
            repeat(it) {
                EmptyStar(
                    starPath = starPath,
                    starPathBounds = starPathBounds,
                    scaleFactor = scaleFactor,
                    starSize = starSize
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RatingWidget() {
    RatingWidget(modifier = Modifier, rating = 3.5, starSize = 30.dp)
}