package com.example.fanfiq.ui.connection

import android.content.Context
import android.net.ConnectivityManager
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fanfiq.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConnectionViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is connection Fragment"
    }
    val text: LiveData<String> = _text



}
