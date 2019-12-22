package com.example.tugasppb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tugasppb.adapter.LvListMenyikapiHoax
import com.example.tugasppb.static_data.ListInfoSertamertaTipsMenyikapiHoax
import kotlinx.android.synthetic.main.activity_ppid_info_public_sertamerta_tips_menyikapi_hoax.*

class PpidInfoPublicSertamertaTipsMenyikapiHoax : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_sertamerta_tips_menyikapi_hoax)
        setToolbar()
        listView.adapter = LvListMenyikapiHoax(
            this,
            ListInfoSertamertaTipsMenyikapiHoax.data,
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
