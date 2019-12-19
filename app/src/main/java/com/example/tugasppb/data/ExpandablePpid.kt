package com.example.tugasppb.data

import com.example.tugasppb.R
import com.example.tugasppb.model.ExpandableGroupParent
import kotlin.collections.ArrayList


object ExpandablePpid {
    val data: ArrayList<ExpandableGroupParent>
        get() {
            val expandableListDetail =
                ArrayList<ExpandableGroupParent>()
            val infoPublick: ArrayList<String> =
                ArrayList()
            infoPublick.add("Informasi Berkala")
            infoPublick.add("Informasi Serta Merta")
            infoPublick.add("Informasi Setiap Saat")
            infoPublick.add("Informasi Dikecualikan")
            val layanan: ArrayList<String> =
                ArrayList()
            layanan.add("Mekanisme Permohonan Informasi")
            layanan.add("Keberatan Informasi")
            layanan.add("Mekanisme Pengajuan Penyelesaian Sengketa Informasi")
            layanan.add("Tata Cara Pengaduan Perilaku ASN")

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