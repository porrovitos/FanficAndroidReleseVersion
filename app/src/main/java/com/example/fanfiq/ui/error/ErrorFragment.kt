package com.example.fanfiq.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fanfiq.MainActivity
import com.example.fanfiq.R

class ErrorFragment : Fragment() {

    private lateinit var connectionViewModel: ErrorViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        connectionViewModel = ViewModelProvider(this).get(ErrorViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_server_error, container, false)
        return root

    }



}