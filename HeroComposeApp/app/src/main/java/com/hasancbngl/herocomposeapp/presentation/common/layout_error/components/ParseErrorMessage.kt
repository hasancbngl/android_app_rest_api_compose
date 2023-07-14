package com.hasancbngl.herocomposeapp.presentation.common.layout_error.components

import android.util.Log
import androidx.paging.LoadState
import java.net.ConnectException
import java.net.SocketTimeoutException

fun parseErrorMessage(error: LoadState.Error): String {
    Log.e("TAG", "parseErrorMessage: $error")
    return when (error.error) {
        is SocketTimeoutException -> "Server Unavailable."
        is ConnectException -> "Internet Unavailable"
        else -> "An error occured."
    }
}