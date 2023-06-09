package com.hasancbngl.herocomposeapp.di

import android.content.Context
import androidx.room.Room
import com.hasancbngl.herocomposeapp.data.local.HeroDatabase
import com.hasancbngl.herocomposeapp.util.Constants.HERO_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun injectRoomDb(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, HeroDatabase::class.java, HERO_DATABASE)
        .build()
}