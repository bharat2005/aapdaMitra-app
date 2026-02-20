package com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.unit.dp
import com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.ModalData
import com.hackathon.aapdamitra.onboard_feature.presentation.onboard_screen.UserDetails

@Composable
fun DetailsStep(
    onNext : () -> Unit,
    userDetails: UserDetails,
    onModalSelected : (ModalData) -> Unit,
    seletedModalData : ModalData?
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {

        //States
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("States")
            Surface(
                onClick = {
                    onModalSelected(userDetails.state)
                }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .background(Color.Gray),
                    contentAlignment = Alignment.Center
                )
                {
                    Text(userDetails.state.selectedOption ?: "")
                }

            }
        }



    }

    if(seletedModalData != null){
        AlertDialog(
            onDismissRequest = {},
            title = {Text(seletedModalData.title)},
            text = {
                LazyColumn {
                    items(seletedModalData.options){option ->
                        Surface(
                            onClick = {}
                        ){
                            Text(option)
                        }
                    }
                }
            },
            confirmButton = {}
        )
    }

}