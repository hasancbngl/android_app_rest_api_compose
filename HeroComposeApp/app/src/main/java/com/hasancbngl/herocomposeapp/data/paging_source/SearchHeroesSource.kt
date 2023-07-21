package com.hasancbngl.herocomposeapp.data.paging_source

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.hasancbngl.herocomposeapp.data.remote.HeroApi
import com.hasancbngl.herocomposeapp.domain.model.Hero
import java.lang.Exception
import javax.inject.Inject

class SearchHeroesSource @Inject constructor(
    private val api: HeroApi,
    private val query: String
) : PagingSource<Int, Hero>() {

    private val TAG = "SearchHeroesSource"

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val apiResponse = api.searchHeroes(name = query)
            val heroes = apiResponse.heroes
            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = apiResponse.prevPage,
                    nextKey = apiResponse.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }
}