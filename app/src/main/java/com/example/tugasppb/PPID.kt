package com.example.tugasppb

import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tugasppb.data.ExpandablePpid
import com.example.tugasppb.adapters.ExpandableListAdapter

class PPID : AppCompatActivity() {
    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableListTitle: ArrayList<String>? = null
    var expandableListDetail: HashMap<String, ArrayList<String>>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ppid)
        expandableListView = findViewById(R.id.expandableList) as ExpandableListView
        expandableListDetail = ExpandablePpid.data
        expandableListTitle = ArrayList(expandableListDetail!!.keys)
        expandableListAdapter = ExpandableListAdapter(this,
            expandableListTitle as ArrayList<String>, expandableListDetail!!
        )
        expandableListView!!.setAdapter(expandableListAdapter)
        expandableListView!!.setOnGroupExpandListener { groupPosition ->
            Toast.makeText(
                applicationContext,
                expandableListTitle!!.get(groupPosition) + " List Expanded.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
