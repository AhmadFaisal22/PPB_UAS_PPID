package com.example.tugasppb.page_berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasppb.R
import com.example.tugasppb.adapter.RVListBerita
import com.example.tugasppb.model.ListBerita
import com.example.tugasppb.utils.RecycleItemTouchHelper
import com.example.tugasppb.utils.RecyclerItemHelperTouchHelperListener
import kotlinx.android.synthetic.main.activity_berita.*

class Berita : AppCompatActivity(), RecyclerItemHelperTouchHelperListener {
    var listBerita = ArrayList<ListBerita>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RVListBerita
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)
        setToolbar()
        init()
        setRecycleLayout()

    }

    private fun init() {
        for (i in 0..9) {
            listBerita.add(
                ListBerita(
                    "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                    "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                    R.drawable.ic_exp_layanan,
                    "Juni 30, 2019"
                )
            )
        }
    }

    fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setRecycleLayout() {
        viewManager = LinearLayoutManager(this)
        viewAdapter = RVListBerita(
            this,
            listBerita
        )
        recyclerView = rvlistBerita.apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter
            itemAnimator = DefaultItemAnimator()
        }

        val itemTouchHelperCallback: ItemTouchHelper.SimpleCallback =
            RecycleItemTouchHelper(0, ItemTouchHelper.LEFT, this)

        ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView)
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int, position: Int) {
        if (viewHolder is RVListBerita.MyViewHolder) {
            var title: String = listBerita.get(viewHolder.adapterPosition).title
            var deleteItem: Int = viewHolder.adapterPosition
            Toast.makeText(this,"Delete "+title,Toast.LENGTH_SHORT).show()
            viewAdapter.removeItem(deleteItem)
            setRecycleLayout()
        }
    }


}
