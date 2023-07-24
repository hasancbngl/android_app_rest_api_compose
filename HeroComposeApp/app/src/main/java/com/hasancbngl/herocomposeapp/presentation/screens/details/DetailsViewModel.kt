package com.hasancbngl.herocomposeapp.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hasancbngl.herocomposeapp.domain.model.Hero
import com.hasancbngl.herocomposeapp.domain.use_cases.UseCases
import com.hasancbngl.herocomposeapp.util.Constants.DETAILS_ARGUMENT_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedHero = mutableStateOf<Hero?>(null)
    val selectedHero: State<Hero?> = _selectedHero

    init {
        viewModelScope.launch {
            val heroId = savedStateHandle.get<Int>(DETAILS_ARGUMENT_KEY)
            _selectedHero.value = heroId?.let { useCases.getSelectedHeroUseCase(it) }
        }
    }
}