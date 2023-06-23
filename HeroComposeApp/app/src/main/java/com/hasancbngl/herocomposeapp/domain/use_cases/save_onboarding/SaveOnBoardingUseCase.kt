package com.hasancbngl.herocomposeapp.domain.use_cases.save_onboarding

import com.hasancbngl.herocomposeapp.data.repository.Repository

class SaveOnBoardingUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(completed: Boolean) {
        repository.saveOnBoardingState(completed)
    }
}