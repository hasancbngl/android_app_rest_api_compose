package com.hasancbngl.herocomposeapp.domain.use_cases.get_selected_Hero

import com.hasancbngl.herocomposeapp.data.repository.Repository
import com.hasancbngl.herocomposeapp.domain.model.Hero
import javax.inject.Inject

class GetSelectedHeroUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero {
        return repository.getSelectedHero(heroId)
    }
}