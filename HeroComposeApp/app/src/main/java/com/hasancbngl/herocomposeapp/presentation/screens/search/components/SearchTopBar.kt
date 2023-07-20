package com.hasancbngl.herocomposeapp.presentation.screens.search.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.ui.theme.topAppBarBackgroundColor
import com.hasancbngl.herocomposeapp.ui.theme.topAppBarContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchTopBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onCloseClicked: () -> Unit
) {
    TopAppBar(
        title = {},
        colors = TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.topAppBarBackgroundColor),
        actions = {
            TextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = text, onValueChange = { onTextChange(it) },
                placeholder = {
                    Text(
                        text = "Search here...",
                        color = Color.White,
                        modifier = Modifier.alpha(.7f)
                    )
                },
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.topAppBarContentColor
                ),
                singleLine = true,
                leadingIcon = {
                    IconButton(
                        modifier = Modifier.alpha(.7f),
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = stringResource(id = R.string.search_icon),
                            tint = MaterialTheme.colorScheme.topAppBarContentColor
                        )
                    }
                },
                trailingIcon = {
                    IconButton(
                        modifier = Modifier.alpha(.7f),
                        onClick = {
                            if (text.isNotEmpty()) {
                                onTextChange("")
                                onCloseClicked()
                            } else onCloseClicked()
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = stringResource(R.string.close_icon),
                            tint = MaterialTheme.colorScheme.topAppBarContentColor
                        )
                    }
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        onSearchClicked(text)
                    }
                ),
                colors = TextFieldDefaults.colors(
                    disabledContainerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    focusedContainerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    unfocusedContainerColor = MaterialTheme.colorScheme.topAppBarBackgroundColor,
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
        })
}


@Preview
@Composable
fun SearchTopBarPrev() {
    SearchTopBar(text = "test", onTextChange = {}, onSearchClicked = {}) {

    }
}