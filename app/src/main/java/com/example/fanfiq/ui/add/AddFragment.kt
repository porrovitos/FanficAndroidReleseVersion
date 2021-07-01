package com.example.fanfiq.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fanfiq.MainActivity
import com.example.fanfiq.R

class AddFragment : Fragment() {

    private lateinit var addViewModel: AddViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addViewModel =
                ViewModelProvider(this).get(AddViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_create_fanfiq, container, false)
        val buttonAdd : Button = root.findViewById(R.id.button_add_title)
        val titleString : EditText = root.findViewById(R.id.input_subtitle_add)
        val nameString : EditText = root.findViewById(R.id.input_create_fancif_name)
        val textString : EditText = root.findViewById(R.id.input_subtext_add)
        val buttonSave : Button = root.findViewById(R.id.button_create_fanfic)

        buttonAdd.setOnClickListener{
            (activity as MainActivity).TitleAndText(titleString.text.toString(), textString.text.toString(), false)
        }

        buttonSave.setOnClickListener{
            (activity as MainActivity).createFanfic(nameString.text.toString())
        }

        return root
    }
}