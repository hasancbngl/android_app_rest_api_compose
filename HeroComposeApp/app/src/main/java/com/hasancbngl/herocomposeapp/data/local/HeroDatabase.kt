package com.hasancbngl.herocomposeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hasancbngl.herocomposeapp.data.local.dao.HeroDao
import com.hasancbngl.herocomposeapp.domain.model.Hero

@Database(
    entities = [Hero::class],
    version = 1
)
abstract class HeroDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
}