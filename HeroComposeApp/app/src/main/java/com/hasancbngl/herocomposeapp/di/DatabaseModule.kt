package com.hasancbngl.herocomposeapp.di

import android.content.Context
import androidx.room.Room
import com.hasancbngl.herocomposeapp.data.local.HeroDatabase
import com.hasancbngl.herocomposeapp.data.local.dao.HeroDao
import com.hasancbngl.herocomposeapp.data.repository.LocalDataSourceImp
import com.hasancbngl.herocomposeapp.domain.repository.LocalDataSource
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
        context, HeroDatabase::class.java, HERO_DATABASE
    )
        .build()

    @Provides
    @Singleton
    fun injectHeroDao(db: HeroDatabase) = db.heroDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(dao:HeroDao): LocalDataSource{
        return LocalDataSourceImp(dao)
    }
}