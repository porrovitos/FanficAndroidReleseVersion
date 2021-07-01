package com.example.fanfiq.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fanfiq.R
import com.example.fanfiq.models.OneFinfic
import kotlinx.android.synthetic.main.row_show_fanfic.view.*

class AllFanficAdapter(
        var items: List<OneFinfic>,
        private val listener: OnItemClickListener
) : RecyclerView.Adapter<AllFanficAdapter.FanficHolder>() {

    inner class FanficHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {

                listener.onItemClick(position, itemView)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FanficHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_show_fanfic, parent, false)
        return FanficHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: FanficHolder, position: Int) {
        holder.itemView.apply {
            author_name_show.text = items[position].author
            title_show.text = items[position].name
            date_show.text = items[position].dateTime
            fanfic_text_show.text = items[position].fanfic
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, itemView: View)
    }
}