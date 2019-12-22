package com.example.tugasppb.static_data

import com.example.tugasppb.model.ListItem

object ListInfoSertamerta {
    val data:ArrayList<ListItem>
        get() {
            data.add(ListItem("Tips Menyikapi Hoax",false))
            return data
        }
}