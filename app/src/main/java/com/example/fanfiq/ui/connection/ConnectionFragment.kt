package com.example.fanfiq.ui.connection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fanfiq.MainActivity
import com.example.fanfiq.R

class ConnectionFragment : Fragment() {

    private lateinit var connectionViewModel: ConnectionViewModel
    private lateinit var connectionActivity: MainActivity

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        connectionViewModel = ViewModelProvider(this).get(ConnectionViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_no_connection, container, false)
        val retry_btn : Button = root.findViewById(R.id.retry_btn)

        connectionActivity = activity as MainActivity
        retry_btn.setOnClickListener{
            connectionActivity.checkConnection()
        }
        return root

    }



}