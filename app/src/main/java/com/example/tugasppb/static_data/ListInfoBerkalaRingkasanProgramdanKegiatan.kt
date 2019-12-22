package com.example.tugasppb.static_data

import com.example.tugasppb.model.ListItem

object ListInfoBerkalaRingkasanProgramdanKegiatan {
    val data:ArrayList<ListItem>
        get() {
            data.add(ListItem("Rencana Kerja Operasional",false))
            data.add(ListItem("Agenda Kerja Dinas",false))
            data.add(ListItem("Kerangka Acuan Kerja",false))
            data.add(ListItem("Perjanjian Kinerja",true))
            data.add(ListItem("Rencana Strategis",true))
            data.add(ListItem("Rencana Kinerja Tahunan",false))
            data.add(ListItem("Cascading",false))
            data.add(ListItem("Indikator Kinerja Utama",false))
            return data
        }
}