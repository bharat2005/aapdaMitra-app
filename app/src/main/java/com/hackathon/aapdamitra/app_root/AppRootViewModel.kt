package com.hackathon.aapdamitra.app_root

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppRootViewModel @Inject constructor(

) : ViewModel() {
    val hi : String = "hello"
}