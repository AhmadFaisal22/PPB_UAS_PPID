package com.example.tugasppb.static_data

import com.example.tugasppb.model.ListItem

object ListInfoSertamerta {
    val data:ArrayList<ListItem>
        get() {
            var dataTemp = ArrayList<ListItem>()
            dataTemp.add(ListItem("Tips Menyikapi Hoax",false))
            return dataTemp
        }
}