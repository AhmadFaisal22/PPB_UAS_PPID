package com.example.tugasppb.page_ppid

import android.content.Intent
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasppb.R
import com.example.tugasppb.adapter.ELSimpleList
import com.example.tugasppb.static_data.ExpandablePpid
import com.example.tugasppb.model.ExpandableGroupParent
import com.example.tugasppb.utils.Utils
import okhttp3.internal.Util


class PPID : AppCompatActivity() {
    var expandableListView: ExpandableListView? = null
    var ELSimpleList: ELSimpleList? = null
    var expandableList: ArrayList<ExpandableGroupParent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid)
        expandableListView = findViewById<ExpandableListView>(R.id.expandableList)
        expandableList = ExpandablePpid.data
        ELSimpleList = ELSimpleList(
            this,
            expandableList!!
        )
        expandableListView!!.setAdapter(ELSimpleList)
//        expandableListView!!.setOnGroupExpandListener { groupPosition -> }
        expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            if (groupPosition == 0) {
                when (childPosition) {
                    0 -> startActivity(Intent(this, PpidInfoPublicBerkala::class.java))
                    1 -> startActivity(Intent(this, PpidInfoPublicSertamerta::class.java))
                    2 -> startActivity(Intent(this, PpidInfoPublicSetiapSaat::class.java))
                    3 -> startActivity(Intent(this, PpidInfoPublicDikecualikan::class.java))
                    else -> Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()
                }
            } else {
                when (childPosition) {
                    0 -> Utils.openBrowser(this,"http://ppid.diskominfo.jatengprov.go.id/layanan/mekanisme-permohonan-informasi/")
                    1 -> Utils.openBrowser(this,"http://ppid.diskominfo.jatengprov.go.id/layanan/keberatan-informasi/")
                    2 -> Utils.openBrowser(this,"http://ppid.diskominfo.jatengprov.go.id/layanan/mekanisme-pengajuan-penyelesaian-sengketa-informasi/")
                    3 -> Utils.openBrowser(this,"http://ppid.diskominfo.jatengprov.go.id/2019/wp-content/uploads/Formulir-Pengaduan-ASN.doc")
                    else -> Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()
                }
            }
            false
        }
    }
}
