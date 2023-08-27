package com.hasancbngl.herocomposeapp.presentation.common.components

import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import com.hasancbngl.herocomposeapp.ui.theme.SMALL_PADDING
import org.junit.Rule
import org.junit.Test

class RatingWidgetTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun passZeroPointZeroValue_Assert_FiveEmptyStars(){
        composeTestRule.apply {
            setContent {
                RatingWidget(modifier = Modifier.padding(SMALL_PADDING), rating = 0.0)
            }
            onAllNodesWithContentDescription("EmptyStar")
                .assertCountEquals(5)
            onAllNodesWithContentDescription("FilledStar")
                .assertCountEquals(0)
            onAllNodesWithContentDescription("HalfFilledStar")
                .assertCountEquals(0)
        }
    }

    @Test
    fun passZeroPointFiveValue_Assert_FourEmptyStars_AndOneHalfFilledStar(){
        composeTestRule.apply {
            setContent {
                RatingWidget(modifier = Modifier.padding(SMALL_PADDING), rating = 0.5)
            }
            onAllNodesWithContentDescription("EmptyStar")
                .assertCountEquals(4)
            onAllNodesWithContentDescription("FilledStar")
                .assertCountEquals(0)
            onAllNodesWithContentDescription("HalfFilledStar")
                .assertCountEquals(1)
        }
    }

    @Test
    fun passZeroPointSixValue_Assert_FourEmptyStars_AndOneFilledStar(){
        composeTestRule.apply {
            setContent {
                RatingWidget(modifier = Modifier.padding(SMALL_PADDING), rating = 0.6)
            }
            onAllNodesWithContentDescription("EmptyStar")
                .assertCountEquals(4)
            onAllNodesWithContentDescription("FilledStar")
                .assertCountEquals(1)
            onAllNodesWithContentDescription("HalfFilledStar")
                .assertCountEquals(0)
        }
    }

    @Test
    fun passFourPointThreeValue_Assert_FourFilledStars(){
        composeTestRule.apply {
            setContent {
                RatingWidget(modifier = Modifier.padding(SMALL_PADDING), rating = 4.3)
            }
            onAllNodesWithContentDescription("EmptyStar")
                .assertCountEquals(0)
            onAllNodesWithContentDescription("FilledStar")
                .assertCountEquals(4)
            onAllNodesWithContentDescription("HalfFilledStar")
                .assertCountEquals(1)
        }
    }

    @Test
    fun passThreePointFiveValue_Assert_ThreeFilledStars_And_OneHalfFilledStar(){
        composeTestRule.apply {
            setContent {
                RatingWidget(modifier = Modifier.padding(SMALL_PADDING), rating = 3.5)
            }
            onAllNodesWithContentDescription("EmptyStar")
                .assertCountEquals(1)
            onAllNodesWithContentDescription("FilledStar")
                .assertCountEquals(3)
            onAllNodesWithContentDescription("HalfFilledStar")
                .assertCountEquals(1)
        }
    }

    @Test
    fun passNegativeValueAssertFiveEmptyStars(){
        composeTestRule.apply {
            setContent {
                RatingWidget(modifier = Modifier.padding(SMALL_PADDING), rating = -4.5)
            }
            onAllNodesWithContentDescription("EmptyStar")
                .assertCountEquals(5)
            onAllNodesWithContentDescription("FilledStar")
                .assertCountEquals(0)
            onAllNodesWithContentDescription("HalfFilledStar")
                .assertCountEquals(0)
        }
    }

    @Test
    fun passInvalidValueAssertFiveEmptyStars(){
        composeTestRule.apply {
            setContent {
                RatingWidget(modifier = Modifier.padding(SMALL_PADDING), rating =5.5)
            }
            onAllNodesWithContentDescription("EmptyStar")
                .assertCountEquals(5)
            onAllNodesWithContentDescription("FilledStar")
                .assertCountEquals(0)
            onAllNodesWithContentDescription("HalfFilledStar")
                .assertCountEquals(0)
        }
    }
}