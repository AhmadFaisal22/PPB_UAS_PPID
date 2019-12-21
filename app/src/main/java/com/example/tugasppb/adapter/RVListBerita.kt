package com.example.tugasppb.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasppb.R
import com.example.tugasppb.model.ListBerita
import kotlinx.android.synthetic.main.item_berita.view.*

class RVListBerita(
    val context: Context,
    private val myDataset: ArrayList<ListBerita>
    ) :
    RecyclerView.Adapter<RVListBerita.MyViewHolder>() {
    inner class MyViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(item: ListBerita) {
            view.title.text = item.title
            view.desc.text = item.desc
            view.date.text = item.date
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_berita, parent, false)
        return MyViewHolder(view)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) = holder.bindData(myDataset[position])
    override fun getItemCount() = myDataset.size
}

