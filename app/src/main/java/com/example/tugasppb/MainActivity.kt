package com.example.tugasppb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun clickMenu(it: View) {
        when (it.id) {
            berita.id -> Log.d("test","Berita")
            ppid.id -> Log.d("test","PPid")
            else -> Toast.makeText(this,"Menu belum terdaftar !",Toast.LENGTH_SHORT).show()
        }

    }
}
