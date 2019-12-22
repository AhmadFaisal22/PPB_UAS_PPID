package com.example.tugasppb.page_ppid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasppb.R
import com.example.tugasppb.adapter.LVSimpleList
import com.example.tugasppb.static_data.ListInfoBerkala
import kotlinx.android.synthetic.main.activity_ppid_info_public_berkala.*

class PpidInfoPublicBerkala : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_berkala)
        setToolbar()
        listView.adapter = LVSimpleList(
            this,
            ListInfoBerkala.data,
            { position ->
                when (position) {
                    0 -> startActivity(Intent(this, PpidInfoPublicBerkalaProfile::class.java))
                    else -> startActivity(Intent(this, PpidInfoPublicBerkalaRingkasan::class.java))
                }
            }
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
