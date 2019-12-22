package com.example.tugasppb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasppb.adapter.LVSimpleList
import com.example.tugasppb.static_data.ListInfoBerkalaRingkasanProgramdanKegiatan
import kotlinx.android.synthetic.main.activity_ppid_info_public_berkala_ringkasan.*

class PpidInfoPublicBerkalaRingkasan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_berkala_ringkasan)
        setToolbar()
        listView.adapter = LVSimpleList(
            this,
            ListInfoBerkalaRingkasanProgramdanKegiatan.data,
            { position -> }
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

}
