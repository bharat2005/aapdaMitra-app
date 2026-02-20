package com.hackathon.aapdamitra.onboard_feature.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.hackathon.aapdamitra.app_root.AppGraphRoutes
import com.hackathon.aapdamitra.onboard_feature.presentation.lang_screen.LangScreen

fun NavGraphBuilder.onboardNavGraph(navController: NavController){

    navigation(
        route  = AppGraphRoutes.OnboardGraph,
        startDestination = OnboardRoutes.LanguagesScreen
    ){
        composable(OnboardRoutes.LanguagesScreen){
            LangScreen(
                navigateToDetailsScreen = {
                    navController.navigate(OnboardRoutes.DetailsScreen)
                }
            )
        }


    }

}