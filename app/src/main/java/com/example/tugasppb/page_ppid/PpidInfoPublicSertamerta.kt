package com.example.tugasppb.page_ppid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasppb.R
import com.example.tugasppb.adapter.LVSimpleList
import com.example.tugasppb.static_data.ListInfoSertamerta
import kotlinx.android.synthetic.main.activity_ppid_info_public_sertamerta.*

class PpidInfoPublicSertamerta : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_sertamerta)
        setToolbar()
        listView.adapter = LVSimpleList(
            this,
            ListInfoSertamerta.data,
            { position ->
                when (position) {
                    0 -> startActivity(Intent(this, PpidInfoPublicSertamertaTipsMenyikapiHoax::class.java))
                    else -> Toast.makeText(
                        this,
                        "Test" + position.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
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
