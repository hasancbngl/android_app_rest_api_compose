package com.hasancbngl.herocomposeapp.presentation.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

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
                filledStars.value = 5
                halfFilledStars.value = 0
                emptyStars.value = 0
            }
        } else {
            Log.d("calculateStars", "Invalid rating number.")
        }
    }
    emptyStars.value = maxStars.value - (filledStars.value + halfFilledStars.value)
    return mapOf(
        "filledStars" to filledStars.value,
        "halfFilledStars" to halfFilledStars.value,
        "emptyStars" to emptyStars.value
    )
}