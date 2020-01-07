package com.example.tugasppb.page_ppid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasppb.R
import com.example.tugasppb.adapter.LVSimpleList
import com.example.tugasppb.static_data.ListInfoBerkalaRingkasanProgramdanKegiatan
import com.example.tugasppb.utils.Utils
import kotlinx.android.synthetic.main.activity_ppid_info_public_berkala_ringkasan.*
import okhttp3.internal.Util

class PpidInfoPublicBerkalaRingkasan : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid_info_public_berkala_ringkasan)
        setToolbar()
        listView.adapter = LVSimpleList(
            this,
            ListInfoBerkalaRingkasanProgramdanKegiatan.data,
            { position ->
                when (position) {
                    0 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/rencana-kerja-operasional-rko-2019/"
                    )
                    1 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/agenda-2020/"
                    )
                    2 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/kak-kerangka-acuan-kerja-2019/"
                    )
                    3 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/09/PK-Eselon-II-2019.pdf"
                    )
                    4 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/09/Rencana-Strategis-2019-2023_.pdf"
                    )
                    5 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/08/RKT-Diskominfo-Jateng-2019.pdf"
                    )
                    6 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2018/08/Cascading-Kinerja-Diskominfo-2018-2023.pdf"
                    )
                    7 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2018/08/IKU-Diskominfo-Jateng-2018-2023-1.pdf"
                    )
                    else-> Toast.makeText(
                        this,
                        "Belum Tersedia" + position.toString(),
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
