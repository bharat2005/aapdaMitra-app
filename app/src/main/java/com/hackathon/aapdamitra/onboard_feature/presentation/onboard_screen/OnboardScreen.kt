package com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.components.DetailsStep
import com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.components.LanguagesStep
import com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.components.LoadingStep
import com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.components.ModesStep

@Composable
fun OnboardScreen(
    viewModel: OnbaordScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    BackHandler {
        viewModel.onBackPress()
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ){


            AnimatedContent(
                targetState = uiState.currentStep,
                transitionSpec = {
                    if(targetState.ordinal > initialState.ordinal){
                        slideInHorizontally(initialOffsetX = {it}) togetherWith
                                slideOutHorizontally(targetOffsetX = {-it})
                    } else {
                        slideInHorizontally(initialOffsetX = {-it}) togetherWith
                                slideOutHorizontally(targetOffsetX = {it})
                    }
                }

            ) { targetState ->
                when(targetState){
                    OnboardSteps.LANGUAGES -> {
                        LanguagesStep(
                            onNext = {viewModel.onNextStep(OnboardSteps.DETAILS)}
                        )
                    }
                    OnboardSteps.DETAILS -> {
                        DetailsStep(
                            onNext = {viewModel.onNextStep(OnboardSteps.MODES)}
                        )
                    }
                    OnboardSteps.MODES -> {
                        ModesStep(
                            onNext = {viewModel.onNextStep(OnboardSteps.LOADING)}
                        )
                    }
                    OnboardSteps.LOADING -> {
                        LoadingStep(
                            navigateToMain = {}
                        )
                    }
                }
            }





        }

    }

}