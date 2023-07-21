package com.hasancbngl.herocomposeapp.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.hasancbngl.herocomposeapp.data.repository.Repository
import com.hasancbngl.herocomposeapp.domain.model.Hero
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchHeroesUseCase @Inject constructor(
    private val repository: Repository
) {

    operator fun invoke(query:String): Flow<PagingData<Hero>> {
        return repository.searchHeroes(query)
    }
}