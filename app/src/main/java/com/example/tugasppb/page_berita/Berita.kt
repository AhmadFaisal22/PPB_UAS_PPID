package com.example.tugasppb.page_berita

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasppb.R
import com.example.tugasppb.adapter.RVListBerita
import com.example.tugasppb.model.ListBerita
import com.example.tugasppb.network.APIUtils
import com.example.tugasppb.network.BeritaService
import com.example.tugasppb.utils.RecycleItemTouchHelper
import com.example.tugasppb.utils.RecyclerItemHelperTouchHelperListener
import com.example.tugasppb.utils.ThreadPolicy
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_berita.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class Berita : AppCompatActivity(), RecyclerItemHelperTouchHelperListener {
    companion object {
        const val PICK_UPDATE_RESULT = 1
        const val PICK_IMAGE = 2
    }

    var listBerita = ArrayList<ListBerita>()
    lateinit var recyclerView: RecyclerView
    lateinit var viewAdapter: RVListBerita
    lateinit var viewManager: RecyclerView.LayoutManager
    lateinit var bottomDialog: BeritaForm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)
        ThreadPolicy.call()
        setToolbar()
        init()
        fabAdd.setOnClickListener {
            bottomDialog = BeritaForm(
                { item: ListBerita ->
                    viewAdapter.addItem(item)
                    Snackbar.make(coordinator, "Sukses Menambahkan", Snackbar.LENGTH_SHORT).show()
                }
                , "Tambah Berita")
            bottomDialog.show(supportFragmentManager, bottomDialog.tag)
        }
    }

    private fun init() {
//        for (i in 0..9) {
//            listBerita.add(
//                ListBerita(
//                    "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
//                    "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
//                    "https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
//                    "Juni 30, 2019",
//                    ""
//                )
//            )
//        }
//        Log.d("smpesini", "test")
        APIUtils.getBeritaService.getBerita()!!.enqueue(object : Callback<ArrayList<ListBerita>> {


            override fun onFailure(call: Call<ArrayList<ListBerita>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<ArrayList<ListBerita>>,
                response: Response<ArrayList<ListBerita>>
            ) {
                listBerita = response.body()!!

                setRecycleLayout()
            }
        })
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
            Toast.makeText(this, "Delete " + title, Toast.LENGTH_SHORT).show()
            viewAdapter.removeItem(deleteItem)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            PICK_UPDATE_RESULT -> {
                if (resultCode === Activity.RESULT_OK) {
                    val dateChange = data!!.getSerializableExtra("data") as ListBerita
                    val position = data!!.getIntExtra("position", 0)
                    viewAdapter.changeItem(dateChange, position)
                }
            }
            PICK_IMAGE -> {
                data?.let {
                    bottomDialog.resultPickImage(it)
                }
            }
        }

    }

}
