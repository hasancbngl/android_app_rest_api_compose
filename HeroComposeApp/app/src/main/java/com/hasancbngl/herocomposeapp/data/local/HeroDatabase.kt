package com.hasancbngl.herocomposeapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hasancbngl.herocomposeapp.data.local.dao.HeroDao
import com.hasancbngl.herocomposeapp.data.local.dao.HeroRemoteKeysDao
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.domain.model.HeroRemoteKeys

@Database(
    entities = [
        Hero::class,
        HeroRemoteKeys::class
    ],
    version = 1
)
@TypeConverters(DatabaseConverter::class)
abstract class HeroDatabase : RoomDatabase() {

    //companion object used in testing
    companion object {
        fun create(context: Context, useInMemory: Boolean): HeroDatabase {
            val databaseBuilder =
                if (useInMemory) Room.inMemoryDatabaseBuilder(context, HeroDatabase::class.java)
                else Room.databaseBuilder(context, HeroDatabase::class.java, "test_database.db")
            return databaseBuilder.fallbackToDestructiveMigration().build()
        }
    }

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}