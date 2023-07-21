package com.hasancbngl.herocomposeapp.data.repository

import android.graphics.pdf.PdfDocument.Page
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.hasancbngl.herocomposeapp.data.local.HeroDatabase
import com.hasancbngl.herocomposeapp.data.paging_source.HeroRemoteMediator
import com.hasancbngl.herocomposeapp.data.paging_source.SearchHeroesSource
import com.hasancbngl.herocomposeapp.data.remote.HeroApi
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ExperimentalPagingApi
class RemoteDataSourceImp @Inject constructor(
    private val heroApi: HeroApi,
    private val heroDb: HeroDatabase
) : RemoteDataSource {

    val heroDao = heroDb.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(3),
            remoteMediator = HeroRemoteMediator(api = heroApi, heroDb = heroDb),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return Pager(
            config = PagingConfig(3),
            pagingSourceFactory = {
                SearchHeroesSource(api = heroApi, query = query)
            }).flow
    }
}