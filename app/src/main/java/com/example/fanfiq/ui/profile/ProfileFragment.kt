package com.example.fanfiq.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fanfiq.MainActivity
import com.example.fanfiq.R


class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        profileViewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        val logout_btn : ImageView = root.findViewById(R.id.button_logout)

        logout_btn.isClickable = true

        logout_btn.setOnClickListener{
            (activity as MainActivity).logout()
        }
        return root
    }
}