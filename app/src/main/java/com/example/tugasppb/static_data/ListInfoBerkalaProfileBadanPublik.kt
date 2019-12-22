package com.example.tugasppb.static_data

import com.example.tugasppb.model.ListItem

object ListInfoBerkalaProfileBadanPublik {
    val data: ArrayList<ListItem>
        get() {
            var dataTemp = ArrayList<ListItem>()
            dataTemp.add(ListItem("Kedudukan Berdasarkan Alamat Lengkap", false))
            dataTemp.add(ListItem("Visi dan Misi", false))
            dataTemp.add(ListItem("Tugas dan Fungsi", false))
            dataTemp.add(ListItem("Struktur Organisasi", true))
            dataTemp.add(ListItem("Layanan Publik", false))
            dataTemp.add(ListItem("Profil Singkat Pejabat Struktural", true))
            dataTemp.add(ListItem("LHKPN", true))
            dataTemp.add(ListItem("Profil Singkat Kepegawaian", false))
            return dataTemp
        }
}