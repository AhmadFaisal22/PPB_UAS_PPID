package com.example.tugasppb.static_data

import com.example.tugasppb.model.ListItem

object ListInfoBerkala {
    val data:ArrayList<ListItem>
        get() {
            val tempData = ArrayList<ListItem>()
            tempData.add(ListItem("Informasi tentang Profile Badan Public",true))
            tempData.add(ListItem("Ringkasan Program & Kegiatan yang sedang dijalankan Dinas Komunikasi dan Informatika Provinsi Jawa Tengah",true))
            return tempData
        }
}