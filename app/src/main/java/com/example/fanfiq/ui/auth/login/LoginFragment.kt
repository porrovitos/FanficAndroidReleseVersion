package com.example.fanfiq.ui.auth.login

import android.os.Bundle
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.fanfiq.*
import com.example.fanfiq.ui.auth.registration.RegistrationFragment
import com.example.fanfiq.ui.error.ErrorFragment
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import javax.security.auth.callback.Callback

class LoginFragment : Fragment() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginActivity: MainActivity

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        loginViewModel =
                ViewModelProvider(this).get(LoginViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_sigin, container, false)

        val sigin_btn : Button = root.findViewById(R.id.button_signin)
        val passwordString : EditText = root.findViewById(R.id.inputPassword)
        val emailString : EditText = root.findViewById(R.id.inputEmail)
        val for_register_btn : TextView = root.findViewById(R.id.text_sigin_page_register)
        for_register_btn.isClickable = true

        loginActivity = activity as MainActivity
        sigin_btn.setOnClickListener{
            loginActivity.login(emailString.text.toString(),passwordString.text.toString())
        }

        for_register_btn.setOnClickListener{
            (activity as MainActivity).setFrag(R.id.navigation_register)
        }
        return root


    }

}