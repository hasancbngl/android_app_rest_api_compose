package com.hasancbngl.herocomposeapp.data.repository

import com.hasancbngl.herocomposeapp.data.local.dao.HeroDao
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.domain.repository.LocalDataSource
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(
    private val dao: HeroDao
) : LocalDataSource {

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return dao.getSelectedHero(heroId)
    }
}