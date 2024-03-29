package com.hasancbngl.herocomposeapp.domain.model

import com.hasancbngl.herocomposeapp.R

sealed class OnBoardingPage(
    val imageResource: Int,
    val title: String,
    val description: String
) {
    object First : OnBoardingPage(
        imageResource = R.drawable.greetings,
        title = "Greetings",
        description = "Are you a Heroes fan? Because if you are then we have a great news for you!"
    )

    object Second : OnBoardingPage(
        imageResource = R.drawable.explore,
        title = "Explore",
        description = "Find your favorite heroes and learn some of the things that you didn't know about."
    )

    object Third : OnBoardingPage(
        imageResource = R.drawable.power,
        title = "Power",
        description = "Check out your hero's power and  see how much are they strong comparing to others."
    )
}