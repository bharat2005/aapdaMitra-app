package com.hackathon.aapdamitra.app_root

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.hackathon.aapdamitra.onboard_feature.presentation.navigation.onboardNavGraph

@Composable
fun AppRoot(
    viewModel: AppRootViewModel = hiltViewModel()
) {
    val navController : NavHostController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ){
        NavHost(
            startDestination = AppGraphRoutes.OnboardGraph,
            navController = navController
        ){

            onboardNavGraph(navController)

        }

    }
}