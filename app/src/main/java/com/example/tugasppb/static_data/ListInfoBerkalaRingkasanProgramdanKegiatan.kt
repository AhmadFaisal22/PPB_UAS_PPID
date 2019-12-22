package com.example.tugasppb.static_data

import com.example.tugasppb.model.ListItem

object ListInfoBerkalaRingkasanProgramdanKegiatan {
    val data: ArrayList<ListItem>
        get() {
            var dataTemp = ArrayList<ListItem>()
            dataTemp.add(ListItem("Rencana Kerja Operasional", false))
            dataTemp.add(ListItem("Agenda Kerja Dinas", false))
            dataTemp.add(ListItem("Kerangka Acuan Kerja", false))
            dataTemp.add(ListItem("Perjanjian Kinerja", true))
            dataTemp.add(ListItem("Rencana Strategis", true))
            dataTemp.add(ListItem("Rencana Kinerja Tahunan", false))
            dataTemp.add(ListItem("Cascading", false))
            dataTemp.add(ListItem("Indikator Kinerja Utama", false))
            return dataTemp
        }
}