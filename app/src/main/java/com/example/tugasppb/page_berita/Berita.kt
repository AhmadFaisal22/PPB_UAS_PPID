package com.example.tugasppb.page_berita

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasppb.R
import com.example.tugasppb.adapter.RVListBerita
import com.example.tugasppb.model.ListBerita
import kotlinx.android.synthetic.main.activity_berita.*

class Berita : AppCompatActivity() {
    var ListBerita = ArrayList<ListBerita>()
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)
        setToolbar()
        init()
        setRecycleLayout()

    }

    private fun init() {
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
                ListBerita(
                    "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                    "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                    R.drawable.ic_exp_layanan,
                    "Juni 30, 2019"
                )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )
        ListBerita.add(
            ListBerita(
                "Ganjar Minta Menteri Ubah Sistem Zonasi pada PPDB Online",
                "SEMARANG – Persoalan Penerimaan Peserta Didik Baru (PPDB) online 2019 untuk SMA/SMK menuai bListBeritaak protes dari masyarakat.",
                R.drawable.ic_exp_layanan,
                "Juni 30, 2019"
            )
        )


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
            ListBerita
        )
        recyclerView = rvListBerita.apply {
            setHasFixedSize(false)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }

}
