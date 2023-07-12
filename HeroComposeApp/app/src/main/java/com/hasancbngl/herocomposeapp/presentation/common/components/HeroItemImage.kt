package com.hasancbngl.herocomposeapp.presentation.common.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import com.hasancbngl.herocomposeapp.R
import com.hasancbngl.herocomposeapp.util.Constants

@Composable
fun HeroItemImage(imageUrl:String) {
    Surface(shape = ShapeDefaults.Large) {
        AsyncImage(
            model = "${Constants.BASE_URL}$imageUrl", contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            error = painterResource(R.drawable.ic_network_error),
            placeholder = painterResource(R.drawable.ic_placeholder),
            contentScale = ContentScale.Crop
        )
    }
}