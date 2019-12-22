package com.example.tugasppb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tugasppb.page_berita.Berita
import com.example.tugasppb.page_ppid.PPID
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickMenu(it: View) {
        when (it.id) {
            berita.id ->  startActivity(Intent(this,
                Berita::class.java))
            ppid.id -> startActivity(Intent(this,
                PPID::class.java))
            else -> Toast.makeText(this,"Menu belum terdaftar !",Toast.LENGTH_SHORT).show()
        }

    }
}
