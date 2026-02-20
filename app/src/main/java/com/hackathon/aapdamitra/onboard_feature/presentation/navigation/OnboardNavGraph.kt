package com.hackathon.aapdamitra.onboard_feature.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.hackathon.aapdamitra.app_root.AppGraphRoutes
import com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.OnboardScreen

fun NavGraphBuilder.onboardNavGraph(navController: NavController){

    composable(
        route = AppGraphRoutes.OnboardGraph
    ){
        OnboardScreen()
    }

}