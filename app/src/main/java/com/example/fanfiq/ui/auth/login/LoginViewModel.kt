package com.example.fanfiq.ui.auth.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val _warningText = MutableLiveData<String>().apply {
        value = "Uncorrected username or password"
    }
    val text: LiveData<String> = _warningText


}