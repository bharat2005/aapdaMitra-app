package com.hackathon.aapdamitra.onboard_feature.presentation.lang_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.hackathon.aapdamitra.app_root.AppRootViewModel

@Composable
fun LangScreen(
    viewModel: LangScreenViewModel = hiltViewModel(),
    navigateToDetailsScreen : () -> Unit,
) {
    val languages : List<String> = mutableListOf(
    "हिंदी",
    "বাংলা",
    "मराठी",
    "தமிழ்",
    "తెలుగు",
    "ಕನ್ನಡ",
    "മലയാളം",
    "ગુજરાતી",
    "ਪੰਜਾਬੀ",
    "ଓଡ଼ିଆ",
    "অসমীয়া",
    "اردو",
    "कोंकणी",
    "ꯃꯤꯇꯩꯂꯣꯟ",
    "बड़ो",
    "संस्कृतम्",
    "मैथिली",
    "ᱥᱟᱱᱛᱟᱲᱤ",
    "डोगरी",
    "कॉशुर"
    )

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues)
        ){


            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(24.dp),
                horizontalArrangement = Arrangement.spacedBy(18.dp),
                verticalArrangement = Arrangement.spacedBy(18.dp)
            ) {

                items(languages){ lang ->
                    Surface(
                        onClick = navigateToDetailsScreen,
                    ){
                        Box(
                            modifier = Modifier.height(80.dp).background(Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(lang)
                        }
                    }

                }

            }



        }

    }

}