package com.example.tugasppb.static_data

import com.example.tugasppb.model.MenyikapiHoax

object ListInfoSertamertaTipsMenyikapiHoax {
    var data = ArrayList<MenyikapiHoax>()
        get() {
            var dataTemp = ArrayList<MenyikapiHoax>()
            dataTemp.add(
                MenyikapiHoax(
                    "Penanggungjawab Pembuatan Informasi",
                    "Kepala Bidang Informasi dan Komunikasi Publik"
                )
            )
            dataTemp.add(
                MenyikapiHoax(
                    "Waktu Pembuatan / Penerbitan Informasi",
                    "Tahun 2017"
                )
            )
            dataTemp.add(
                MenyikapiHoax(
                    "Bentuk Informasi yang Tersedia",
                    "Salinan digital"
                )
            )
            dataTemp.add(
                MenyikapiHoax(
                    "Jangka Waktu Penyimpanan",
                    "5 Tahun"
                )
            )
            dataTemp.add(
                MenyikapiHoax(
                    "Jenis File",
                    "Multimedia (tautan youtube), klik untuk melihat"
                )
            )
            return dataTemp
        }
}