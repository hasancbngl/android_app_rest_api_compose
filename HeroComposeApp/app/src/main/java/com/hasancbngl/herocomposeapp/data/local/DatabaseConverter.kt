package com.hasancbngl.herocomposeapp.data.local

import androidx.room.TypeConverter

class DatabaseConverter {

    private val separator = ","

    @TypeConverter
    fun fromListToString(list: List<String>): String {
        return list.joinToString(separator = separator)
    }

    @TypeConverter
    fun fromStringToList(string: String): List<String> {
        return string.split(separator)
    }
}