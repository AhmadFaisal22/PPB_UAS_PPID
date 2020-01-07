package com.example.tugasppb.page_ppid

import android.app.DownloadManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.tugasppb.R
import com.example.tugasppb.adapter.LVListInfoDekecualikan
import com.example.tugasppb.adapter.LVSimpleList
import com.example.tugasppb.static_data.ListInfoDikecualikan
import com.example.tugasppb.static_data.ListInfoSertamerta
import com.example.tugasppb.utils.Utils
import kotlinx.android.synthetic.main.activity_ppid_info_public_sertamerta.*

class PpidInfoPublicDikecualikan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_dikecualikan)
        setToolbar()
        listView.adapter = LVListInfoDekecualikan(
            this,
            ListInfoDikecualikan.data,
            { position ->
                Log.d("=================",position.toString())
                Toast.makeText(this,"Donwload File ...",Toast.LENGTH_SHORT).show()
                Utils.downloadUrl(this,ListInfoDikecualikan.data[position].url)
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
