package com.example.tugasppb.static_data

import com.example.tugasppb.model.InformasiDikecualikan
import com.example.tugasppb.model.ListItem

object ListInfoDikecualikan {
    val data: ArrayList<InformasiDikecualikan>
        get() {
            var dataTemp = ArrayList<InformasiDikecualikan>()
            dataTemp.add(
                InformasiDikecualikan(
                    "PPID Dinas Komunikasi Informatika Provinsi Jawa Tengah Telah Melakukan Uji Konsekuensi Informasi Publik",
                    "Pada Tanggal 25 April 2019",
                    "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/08/SK-DIK-2019.pdf"
                )
            )
            dataTemp.add(
                InformasiDikecualikan(
                    "PPID Dinas Komunikasi Informatika Provinsi Jawa Tengah Telah Melakukan Uji Konsekuensi Informasi Publik",
                    "Pada Tanggal 9 April 2018",
                    "https://ppid.diskominfo.jatengprov.go.id/wp-content/uploads/2019/08/Scan-DI-Dikecualikan.pdf"
                )
            )
            dataTemp.add(
                InformasiDikecualikan(
                    "PPID Dinas Komunikasi Informatika Provinsi Jawa Tengah Telah Melakukan Uji Konsekuensi Informasi Publik",
                    "Pada Tanggal 6 Juni 2017",
                    "Terlampir (Penetapan Klasifikasi Informasi Dikecualikan, Undangan, Daftar Hadir Serta Dokumentasi Uji Konsekuensi PPID Diskominfo )"
                )
            )
            return dataTemp
        }
}