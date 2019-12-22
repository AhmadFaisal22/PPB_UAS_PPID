package com.example.tugasppb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tugasppb.R
import com.example.tugasppb.model.InformasiDikecualikan

class LVListInfoDekecualikan(
    private val context: Context,
    private val list: ArrayList<InformasiDikecualikan>,
    val callback: (position: Int) -> Unit
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.item_informasi_dikecualikan, parent, false)
        rowView?.findViewById<TextView>(R.id.title)!!.text = getItem(position).title
        rowView?.findViewById<TextView>(R.id.date)!!.text = getItem(position).date
        rowView.setOnClickListener {
            callback(position)
        }
        return rowView
    }

    override fun getItem(position: Int): InformasiDikecualikan {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }
}