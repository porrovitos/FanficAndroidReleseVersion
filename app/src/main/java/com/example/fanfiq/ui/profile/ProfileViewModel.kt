package com.example.fanfiq.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fanfiq.models.User

class ProfileViewModel : ViewModel() {

    private val _email = MutableLiveData<String>().apply {
        value = "test"
    }
    val text: LiveData<String> = _email
}