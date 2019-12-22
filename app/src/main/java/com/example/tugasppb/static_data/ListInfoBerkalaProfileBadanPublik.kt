package com.example.tugasppb.static_data

import com.example.tugasppb.model.ListItem

object ListInfoBerkalaProfileBadanPublik {
    val data:ArrayList<ListItem>
        get() {
            data.add(ListItem("Kedudukan Berdasarkan Alamat Lengkap",false))
            data.add(ListItem("Visi dan Misi",false))
            data.add(ListItem("Tugas dan Fungsi",false))
            data.add(ListItem("Struktur Organisasi",true))
            data.add(ListItem("Layanan Publik",false))
            data.add(ListItem("Profil Singkat Pejabat Struktural",true))
            data.add(ListItem("LHKPN",true))
            data.add(ListItem("Profil Singkat Kepegawaian",false))
            return data
        }
}