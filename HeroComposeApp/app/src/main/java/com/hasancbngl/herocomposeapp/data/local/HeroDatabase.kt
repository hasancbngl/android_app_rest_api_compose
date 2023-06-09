package com.hasancbngl.herocomposeapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hasancbngl.herocomposeapp.data.local.dao.HeroDao
import com.hasancbngl.herocomposeapp.data.local.dao.HeroRemoteKeyDao
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.domain.model.HeroRemoteKey

@Database(
    entities = [
        Hero::class,
        HeroRemoteKey::class
    ],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}