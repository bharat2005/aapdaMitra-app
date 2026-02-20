package com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun LanguageButton(
    onClick : () -> Unit,
    label : String
) {

    Surface(
        onClick = onClick
    ){
        Box(
            modifier = Modifier.height(80.dp).background(Color.Gray),
            contentAlignment = Alignment.Center
        ){
            Text(label)
        }
    }

}