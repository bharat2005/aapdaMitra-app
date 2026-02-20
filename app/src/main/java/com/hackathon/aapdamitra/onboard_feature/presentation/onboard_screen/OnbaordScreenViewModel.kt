package com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

enum class OnboardSteps{
    LANGUAGES,
    DETAILS,
    MODES,
    LOADING
}
data class OnboardStates(
    val currentStep : OnboardSteps = OnboardSteps.LANGUAGES
)
@HiltViewModel
class OnbaordScreenViewModel @Inject constructor(
) : ViewModel() {
    private val _uiState = MutableStateFlow(OnboardStates())
    val uiState = _uiState.asStateFlow()

    fun onBackPress(){
        val currentStep = uiState.value.currentStep
        val prevStep = when(currentStep){
            OnboardSteps.LANGUAGES -> null
            OnboardSteps.DETAILS -> OnboardSteps.LANGUAGES
            OnboardSteps.MODES -> OnboardSteps.DETAILS
            OnboardSteps.LOADING -> OnboardSteps.MODES
        }
        if(prevStep != null){
            _uiState.update { it.copy(currentStep = prevStep) }
        }
    }

    fun onNextStep(step : OnboardSteps){
        _uiState.update { it.copy(currentStep = step) }
    }



}