package com.hasancbngl.herocomposeapp.domain.repository

import com.hasancbngl.herocomposeapp.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId:Int) : Hero
}