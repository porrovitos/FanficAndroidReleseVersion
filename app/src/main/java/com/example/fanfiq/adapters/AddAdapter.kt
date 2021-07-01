package com.example.fanfiq.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.fanfiq.R
import com.example.fanfiq.models.AddModel

class AddAdapter(var mCtx: Context, var resourser: Int, var items: List<AddModel>) : ArrayAdapter<AddModel>(mCtx, resourser, items) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)
        val view: View = layoutInflater.inflate(resourser, null)

        var mItem: AddModel = items[position]
        val titleTextView: TextView = view.findViewById(R.id.titleRow)
        val textTextView: TextView = view.findViewById(R.id.authorRow)

        titleTextView.text = mItem.title
        textTextView.text = mItem.text

        return view
    }
}