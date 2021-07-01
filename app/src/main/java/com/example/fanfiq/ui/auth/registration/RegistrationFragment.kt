package com.example.fanfiq.ui.auth.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fanfiq.MainActivity
import com.example.fanfiq.R

class RegistrationFragment : Fragment() {

    private lateinit var registrationViewModel: RegistrationViewModel
    private lateinit var registrationActivity: MainActivity

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        registrationViewModel =
                ViewModelProvider(this).get(RegistrationViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_registration, container, false)

        val reg_btn : Button = root.findViewById(R.id.button_registerReg)
        val passwordString : EditText = root.findViewById(R.id.inputPasswordReg)
        val emailString : EditText = root.findViewById(R.id.inputEmailReg)
        val usernameString : EditText = root.findViewById(R.id.inputNicknameReg)

        registrationActivity = activity as MainActivity
        reg_btn.setOnClickListener{
            registrationActivity.registration(emailString.text.toString(),passwordString.text.toString(), usernameString.text.toString())
        }
        return root
    }
}