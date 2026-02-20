package com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

enum class OnboardSteps {
    LANGUAGES,
    DETAILS,
    MODES,
    LOADING
}

data class ModalData(
    val title: String,
    val options: List<String>,
    val selectedOption: String?
)

data class UserDetails(
    val state: ModalData = ModalData(
        title = "States",
        options = listOf(
            "Andhra Pradesh",
            "Arunachal Pradesh",
            "Assam",
            "Bihar",
            "Chhattisgarh",
            "Goa",
            "Gujarat",
            "Haryana",
            "Himachal Pradesh",
            "Jharkhand",
            "Karnataka",
            "Kerala",
            "Madhya Pradesh",
            "Maharashtra",
            "Manipur",
            "Meghalaya",
            "Mizoram",
            "Nagaland",
            "Odisha",
            "Punjab",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telangana",
            "Tripura",
            "Uttar Pradesh",
            "Uttarakhand",
            "West Bengal"
        ),
        selectedOption = null
    ),
    val birthYear: ModalData = ModalData(
        title = "Year of Birth",
        options = listOf(
            "1960","1961","1962","1963","1964","1965","1966","1967","1968","1969",
"1970","1971","1972","1973","1974","1975","1976","1977","1978","1979",
"1980","1981","1982","1983","1984","1985","1986","1987","1988","1989",
"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999",
"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009",
"2010"
),
        selectedOption = null
    ),
    val gender: ModalData = ModalData(
        title = "Gender",
        options = listOf(
            "Male",
            "Female",
            "Other"
        ),
        selectedOption = null
    )
)

data class OnboardStates(
    val currentStep: OnboardSteps = OnboardSteps.LANGUAGES,
    val userDetails: UserDetails = UserDetails(),
    val selectedModal : ModalData? = null,
)

@HiltViewModel
class OnbaordScreenViewModel @Inject constructor(
) : ViewModel() {
    private val _uiState = MutableStateFlow(OnboardStates())
    val uiState = _uiState.asStateFlow()

    //Steps States
    fun onBackPress() {
        val currentStep = uiState.value.currentStep
        val prevStep = when (currentStep) {
            OnboardSteps.LANGUAGES -> null
            OnboardSteps.DETAILS -> OnboardSteps.LANGUAGES
            OnboardSteps.MODES -> OnboardSteps.DETAILS
            OnboardSteps.LOADING -> OnboardSteps.MODES
        }
        if (prevStep != null) {
            _uiState.update { it.copy(currentStep = prevStep) }
        }
    }
    fun onNextStep(step: OnboardSteps) {
        _uiState.update { it.copy(currentStep = step) }
    }


    //Modal States
    fun onModalSelected(selectedModal : ModalData){
        _uiState.update { it.copy(selectedModal = selectedModal) }
    }
    fun onModalDismiss(){
        _uiState.update { it.copy(selectedModal = null) }
    }
    fun onSelectedOption(option : String){
        //update Seleted ModalData
        _uiState.update { it.copy(selectedModal = it.selectedModal!!.copy(selectedOption = option)) }

        //update Modal Data of choosed feild
        when(uiState.value.selectedModal){
            uiState.value.userDetails.state -> {
                _uiState.update { it.copy(userDetails = it.userDetails.copy(state = it.userDetails.state.copy(selectedOption = option))) }
            }

            uiState.value.userDetails.birthYear -> {
                _uiState.update { it.copy(userDetails = it.userDetails.copy(state = it.userDetails.birthYear.copy(selectedOption = option))) }
            }

            uiState.value.userDetails.gender -> {
                _uiState.update { it.copy(userDetails = it.userDetails.copy(state = it.userDetails.gender.copy(selectedOption = option))) }
            }
        }
    }


}