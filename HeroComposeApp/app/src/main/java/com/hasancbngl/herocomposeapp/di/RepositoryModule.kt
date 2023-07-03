package com.hasancbngl.herocomposeapp.di

import android.content.Context
import com.hasancbngl.herocomposeapp.data.repository.DataStoreOperationsImp
import com.hasancbngl.herocomposeapp.data.repository.Repository
import com.hasancbngl.herocomposeapp.domain.repository.DataStoreOperations
import com.hasancbngl.herocomposeapp.domain.use_cases.UseCases
import com.hasancbngl.herocomposeapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.hasancbngl.herocomposeapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.hasancbngl.herocomposeapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations = DataStoreOperationsImp(context)

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository)
        )
    }
}