package com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LanguagesStep(
    onNext : () -> Unit,
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


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(horizontal = 12.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(languages) {

            }

        }


    }

}