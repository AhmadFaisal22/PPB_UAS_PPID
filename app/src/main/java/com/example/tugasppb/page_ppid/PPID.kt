package com.example.tugasppb.page_ppid

import android.content.Intent
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasppb.R
import com.example.tugasppb.adapter.ELSimpleList
import com.example.tugasppb.static_data.ExpandablePpid
import com.example.tugasppb.model.ExpandableGroupParent


class PPID : AppCompatActivity() {
    var expandableListView: ExpandableListView? = null
    var ELSimpleList: ELSimpleList? = null
    var expandableList: ArrayList<ExpandableGroupParent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid)
        expandableListView = findViewById<ExpandableListView>(R.id.expandableList)
        expandableList = ExpandablePpid.data
        ELSimpleList = ELSimpleList(
            this,
            expandableList!!
        )
        expandableListView!!.setAdapter(ELSimpleList)
//        expandableListView!!.setOnGroupExpandListener { groupPosition -> }
        expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            if (groupPosition == 0) {
                when (childPosition) {
                    0 -> startActivity(Intent(this, PpidInfoPublicBerkala::class.java))
                    1 -> startActivity(Intent(this, PpidInfoPublicSertamerta::class.java))
                    3 -> startActivity(Intent(this, PpidInfoPublicDikecualikan::class.java))
                    else -> Toast.makeText(this, "message", Toast.LENGTH_SHORT).show()
                }
            } else {

            }
            false
        }
    }
}
