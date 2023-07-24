package com.hasancbngl.herocomposeapp.domain.use_cases

import com.hasancbngl.herocomposeapp.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.hasancbngl.herocomposeapp.domain.use_cases.get_selected_Hero.GetSelectedHeroUseCase
import com.hasancbngl.herocomposeapp.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.hasancbngl.herocomposeapp.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.hasancbngl.herocomposeapp.domain.use_cases.search_heroes.SearchHeroesUseCase

data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)