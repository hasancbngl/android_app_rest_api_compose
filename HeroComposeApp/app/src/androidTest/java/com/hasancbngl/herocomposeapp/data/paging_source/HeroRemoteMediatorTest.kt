package com.hasancbngl.herocomposeapp.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.test.core.app.ApplicationProvider
import com.hasancbngl.herocomposeapp.data.local.HeroDatabase
import com.hasancbngl.herocomposeapp.data.remote.FakeHeroApi2
import com.hasancbngl.herocomposeapp.domain.model.Hero
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediatorTest {

    private lateinit var heroApi: FakeHeroApi2
    private lateinit var database: HeroDatabase

    @Before
    fun setup() {
        heroApi = FakeHeroApi2()
        database = HeroDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @After
    fun cleanUp() {
        database.clearAllTables()
    }


    @Test
    fun refreshLoadReturnsSuccessResultWhenMoreDataIsPresent() = runBlocking {
        val remoteMediator = HeroRemoteMediator(
            api = heroApi,
            heroDb = database,
            dao = database.heroDao()
        )
        val pagingState = PagingState<Int, Hero>(
            pages = emptyList(),
            anchorPosition = null,
            config = PagingConfig(3),
            leadingPlaceholderCount = 0
        )
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)
        assertTrue(result is RemoteMediator.MediatorResult.Success)
        assertFalse((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)
    }

    @Test
    fun refreshLoadSuccessAndEndOfPaginationTrueWhenNoMoreData() = runBlocking {
        heroApi.clearPage1()
        val remoteMediator = HeroRemoteMediator(
            api = heroApi,
            heroDb = database,
            dao = database.heroDao()
        )
        val pagingState = PagingState<Int, Hero>(
            pages = emptyList(),
            anchorPosition = null,
            config = PagingConfig(3),
            leadingPlaceholderCount = 0
        )
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)
        assertTrue(result is RemoteMediator.MediatorResult.Success)
        assertTrue((result as RemoteMediator.MediatorResult.Success).endOfPaginationReached)
    }

    @Test
    fun refreshLoadReturnsErrorResultWhenErrorOccurs() = runBlocking {
        heroApi.addException()
        val remoteMediator = HeroRemoteMediator(
            api = heroApi,
            heroDb = database,
            dao = database.heroDao()
        )
        val pagingState = PagingState<Int, Hero>(
            pages = emptyList(),
            anchorPosition = null,
            config = PagingConfig(3),
            leadingPlaceholderCount = 0
        )
        val result = remoteMediator.load(LoadType.REFRESH, pagingState)
        assertTrue(result is RemoteMediator.MediatorResult.Error)
    }
}