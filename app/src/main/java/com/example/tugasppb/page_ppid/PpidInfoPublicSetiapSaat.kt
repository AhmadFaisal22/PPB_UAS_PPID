package com.example.tugasppb.page_ppid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tugasppb.R
import com.example.tugasppb.utils.Utils
import kotlinx.android.synthetic.main.activity_ppid_info_public_sertamerta_tips_menyikapi_hoax.*
import kotlinx.android.synthetic.main.activity_ppid_info_public_setiap_saat.*
import kotlinx.android.synthetic.main.activity_ppid_info_public_setiap_saat.toolbar

class PpidInfoPublicSetiapSaat : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_setiap_saat)
        setToolbar()
    }
    fun setToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
    fun onClickLihat(it: View) {
        when (it.id) {
            id0.id -> Utils.openBrowser(
                this,
                "https://ppid.diskominfo.jatengprov.go.id/daftar-informasi-publik-tahun-2019/"
            )
            id1.id -> Utils.openBrowser(
                this,
                "https://ppid.diskominfo.jatengprov.go.id/informasi-publik/informasi-setiap-saat/"
            )
            id2.id -> Utils.openBrowser(
                this,
                "http://ppid.diskominfo.jatengprov.go.id/index.php/daftar-peraturan-keputusan-kebijakan-urusan-komunikas-dan-informatika-persandian-dan-statistik/"
            )
            id3.id -> Utils.openBrowser(
                this,
                "https://drive.google.com/drive/folders/1z2MLiyJeujC0xtlMoZ3HosRGsq2ETlPQ?usp=sharing"
            )
            id4.id -> Utils.openBrowser(
                this,
                "http://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/09/SK-Standar-Pelayanan-Publik.pdf"
            )
            else -> ""
        }
    }
}
