package com.hasancbngl.herocomposeapp.data.repository

import androidx.paging.PagingData
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.domain.repository.DataStoreOperations
import com.hasancbngl.herocomposeapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val dataStoreOperations: DataStoreOperations,
    private val remoteDataSourceImp: RemoteDataSource
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remoteDataSourceImp.getAllHeroes()
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStoreOperations.saveOnBoardingState(completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStoreOperations.readOnBoardingState()
    }
}