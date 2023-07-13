package com.hasancbngl.herocomposeapp.presentation.common.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.hasancbngl.herocomposeapp.util.Constants.EMPTY_STARS
import com.hasancbngl.herocomposeapp.util.Constants.FILLED_STARS
import com.hasancbngl.herocomposeapp.util.Constants.HALF_FILLED_STARS

@Composable
fun calculateStars(rating: Double): Map<String, Int> {
    val maxStars = remember { mutableStateOf(5) }
    val filledStars = remember { mutableStateOf(0) }
    val halfFilledStars = remember { mutableStateOf(0) }
    val emptyStars = remember { mutableStateOf(0) }

    LaunchedEffect(key1 = rating) {
        val (firstNumber, lastNumber) = rating.toString().split(".")
            .map { it.toInt() }
        if (firstNumber in 0..5 && lastNumber in 0..9) {
            filledStars.value = firstNumber
            if (lastNumber in 1..5) halfFilledStars.value++
            if (lastNumber in 6..9) filledStars.value++
            if (firstNumber == 5 && lastNumber > 0) {
                emptyStars.value = 5
                filledStars.value = 0
                halfFilledStars.value = 0
            }
        } else {
            Log.d("calculateStars", "Invalid rating number.")
        }
    }
    emptyStars.value = maxStars.value - (filledStars.value + halfFilledStars.value)
    return mapOf(
        FILLED_STARS to filledStars.value,
        HALF_FILLED_STARS to halfFilledStars.value,
        EMPTY_STARS to emptyStars.value
    )
}