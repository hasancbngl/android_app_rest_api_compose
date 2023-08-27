package com.hasancbngl.herocomposeapp.presentation.screens.search.components

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class SearchTopBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun openSearchWidget_addInputText_assertInputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            SearchTopBar(
                text = text.value,
                onTextChange = {
                    text.value = it
                },
                onSearchClicked = {},
                onCloseClicked = {}
            )
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("test text")
        composeTestRule.onNodeWithContentDescription("TextField")
            .assertTextEquals("test text")
    }

    @Test
    fun openSearchWidget_addInputText_pressCloseButtonOnce_assertEmptyInputText() {
        val text = mutableStateOf("")
        composeTestRule.apply {
            setContent {
                SearchTopBar(
                    text = text.value,
                    onTextChange = {
                        text.value = it
                    },
                    onSearchClicked = {},
                    onCloseClicked = {}
                )
            }

            onNodeWithContentDescription("TextField")
                .performTextInput("test text")
            onNodeWithContentDescription("CloseButton").performClick()
            onNodeWithContentDescription("TextField").assertTextContains("")
        }
    }

    @Test
    fun openSearchWidget_addInputText_pressCloseButtonTwice_assertClosedState() {
        val text = mutableStateOf("")
        val isSearchTopBarVisible = mutableStateOf(true)
        composeTestRule.apply {
            setContent {
                if (isSearchTopBarVisible.value) SearchTopBar(
                    text = text.value,
                    onTextChange = {
                        text.value = it
                    },
                    onSearchClicked = {},
                    onCloseClicked = {
                        isSearchTopBarVisible.value = false
                    }
                )
            }

            onNodeWithContentDescription("TextField")
                .performTextInput("test text")
            onNodeWithContentDescription("CloseButton").performClick()
            onNodeWithContentDescription("CloseButton").performClick()
            onNodeWithContentDescription("SearchTopBar")
                .assertDoesNotExist()
        }
    }

    @Test
    fun openSearchWidget_pressCloseButtonOnce_whenInputIsEmpty_assertClosedState() {
        val isSearchTopBarVisible = mutableStateOf(true)
        composeTestRule.apply {
            setContent {
                if (isSearchTopBarVisible.value) SearchTopBar(
                    text = "",
                    onTextChange = {},
                    onSearchClicked = {},
                    onCloseClicked = {
                        isSearchTopBarVisible.value = false
                    }
                )
            }

            onNodeWithContentDescription("CloseButton").performClick()
            onNodeWithContentDescription("SearchTopBar")
                .assertDoesNotExist()
        }
    }
}