package com.example.tugasppb.page_ppid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugasppb.R
import com.example.tugasppb.adapter.LVSimpleList
import com.example.tugasppb.static_data.ListInfoBerkalaProfileBadanPublik
import com.example.tugasppb.utils.Utils
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
                when (position) {
                    0 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/profil/profil-ppid-diskominfo/"
                    )
                    1 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/profil/visi-misi/"
                    )
                    2 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/tugas-ppid/"
                    )
                    3 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/struktur-organisasi-ppid-diskominfo-prov-jateng/"
                    )
                    4 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/layanan-publik-dinas-kominfo/"
                    )
                    5 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/profil-lengkap-pejabat-struktural/"
                    )
                    6 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/07/LHKPN-Bu-Riena-2018.pdf"
                    )
                    7 -> Utils.openBrowser(
                        this,
                        "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/09/Profil-Singkat-Kepegawaian-2019.pdf"
                    )
                    else -> Toast.makeText(
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
