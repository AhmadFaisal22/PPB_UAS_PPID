package com.example.tugasppb.static_data

import com.example.tugasppb.R
import com.example.tugasppb.model.ExpandableGroupParent
import com.example.tugasppb.model.ListItem
import kotlin.collections.ArrayList


object ExpandablePpid {
    val data: ArrayList<ExpandableGroupParent>
        get() {
            val expandableListDetail =
                ArrayList<ExpandableGroupParent>()
            val infoPublick: ArrayList<ListItem> =
                ArrayList()
            infoPublick.add(ListItem("Informasi Berkala",true))
            infoPublick.add(ListItem("Informasi Serta Merta",true))
            infoPublick.add(ListItem("Informasi Setiap Saat",true))
            infoPublick.add(ListItem("Informasi Dikecualikan",true))
            val layanan: ArrayList<ListItem> =
                ArrayList()
            layanan.add(ListItem("Mekanisme Permohonan Informasi",false))
            layanan.add(ListItem("Keberatan Informasi",false))
            layanan.add(ListItem("Mekanisme Pengajuan Penyelesaian Sengketa Informasi",false))
            layanan.add(ListItem("Tata Cara Pengaduan Perilaku ASN",false))

            expandableListDetail.add(
                ExpandableGroupParent(
                    "Info Public",
                    R.drawable.ic_exp_info_public,
                    infoPublick
                )
            )
            expandableListDetail.add(
                ExpandableGroupParent(
                    "Layanan",
                    R.drawable.ic_exp_layanan,
                    layanan
                )
            )
            return expandableListDetail
        }
}