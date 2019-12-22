package com.example.tugasppb.static_data

import com.example.tugasppb.model.InformasiDikecualikan
import com.example.tugasppb.model.ListItem

object ListInfoDikecualikan {
    val data: ArrayList<InformasiDikecualikan>
        get() {
            var dataTemp = ArrayList<InformasiDikecualikan>()
            dataTemp.add(
                InformasiDikecualikan(
                    "TPPID Dinas Komunikasi Informatika Provinsi Jawa Tengah Telah Melakukan Uji Konsekuensi Informasi Publik",
                    "Pada Tanggal 25 April 2019"
                )
            )
            dataTemp.add(
                InformasiDikecualikan(
                    "TPPID Dinas Komunikasi Informatika Provinsi Jawa Tengah Telah Melakukan Uji Konsekuensi Informasi Publik",
                    "Pada Tanggal 25 April 2019"
                )
            )
            dataTemp.add(
                InformasiDikecualikan(
                    "TPPID Dinas Komunikasi Informatika Provinsi Jawa Tengah Telah Melakukan Uji Konsekuensi Informasi Publik",
                    "Pada Tanggal 25 April 2019"
                )
            )
            return dataTemp
        }
}