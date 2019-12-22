package com.example.tugasppb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.tugasppb.model.ListBerita
import kotlinx.android.synthetic.main.activity_berita_detail.*

class BeritaDetail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita_detail)
        setToolbar()
        setToLayout()
    }
    fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setToLayout(){
        val data =intent.getSerializableExtra("data") as ListBerita;
        findViewById<TextView>(R.id.title).text = data.title
        image.setImageResource(data.image)
        desc.text = data.desc
    }
}
