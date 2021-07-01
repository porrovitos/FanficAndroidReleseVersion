package com.example.fanfiq.ui.auth.registration

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel : ViewModel() {

    private val _warningText = MutableLiveData<String>().apply {
        value = "This nickname or email is already use"
    }
    val text: LiveData<String> = _warningText
}