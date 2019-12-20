package com.example.tugasppb

import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasppb.adapter.ExpandableListAdapter
import com.example.tugasppb.data.ExpandablePpid
import com.example.tugasppb.model.ExpandableGroupParent


class PPID : AppCompatActivity() {
    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableList: ArrayList<ExpandableGroupParent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid)
        expandableListView = findViewById<ExpandableListView>(R.id.expandableList)
        expandableList = ExpandablePpid.data
        expandableListAdapter = ExpandableListAdapter(
            this,
            expandableList!!
        )
        expandableListView!!.setAdapter(expandableListAdapter)
        expandableListView!!.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(
                applicationContext,
                expandableList!!.get(groupPosition).title + " List Expanded.",
                Toast.LENGTH_SHORT
            ).show()
        }
        expandableListView!!.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
            Toast.makeText(
                applicationContext,
                expandableList!![groupPosition].title + " -> "
                        + expandableList!![groupPosition].listChild[childPosition],
                Toast.LENGTH_SHORT
            ).show()
            false
        }
    }
}
