package com.example.tugasppb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasppb.adapter.LVSimpleList
import com.example.tugasppb.static_data.ListInfoBerkalaProfileBadanPublik
import kotlinx.android.synthetic.main.activity_ppid_info_public_berkala_profile.*

class PpidInfoPublicBerkalaProfile : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_berkala_profile)
        setToolbar()
        listView.adapter = LVSimpleList(
            this,
            ListInfoBerkalaProfileBadanPublik.data,
            { position ->
                Toast.makeText(this, "Test" + position.toString(), Toast.LENGTH_SHORT).show()
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
