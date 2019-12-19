package com.example.tugasppb.adapter

import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.tugasppb.R
import com.example.tugasppb.model.ExpandableGroupParent

class ExpandableListAdapter(
    val context: Context,
    val expandableList: ArrayList<ExpandableGroupParent>
    ) : BaseExpandableListAdapter() {
    override fun getChild(listPosition: Int, expandedListPosition: Int): Any {
        return getGroup(listPosition).listChild[expandedListPosition]
    }

    override fun getChildId(listPosition: Int, expandedListPosition: Int): Long {
        return expandedListPosition.toLong()
    }

    override fun getChildView(
        listPosition: Int, expandedListPosition: Int,
        isLastChild: Boolean, convertView: View?, parent: ViewGroup?
    ): View? {
        var view = convertView

        val expandedListText =
            getChild(listPosition, expandedListPosition) as String

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = layoutInflater.inflate(R.layout.item_expandable_item, null)

        val expandedListTextView = view?.findViewById(R.id.title) as TextView
            expandedListTextView.text = expandedListText

        return view
    }

    override fun getChildrenCount(listPosition: Int): Int {
        return expandableList[listPosition].listChild.size
    }

    override fun getGroup(listPosition: Int): ExpandableGroupParent {
        return expandableList[listPosition]
    }

    override fun getGroupCount(): Int {
        return expandableList.size
    }

    override fun getGroupId(listPosition: Int): Long {
        return listPosition.toLong()
    }

    override fun getGroupView(
        listPosition: Int, isExpanded: Boolean,
        convertView: View?, parent: ViewGroup?
    ): View? {
        var view: View? = convertView
        val listTitle = getGroup(listPosition).title
        val listImage = getGroup(listPosition).image
        if (view == null) {
            val layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = layoutInflater.inflate(R.layout.item_expandable_group, null)
        }
        val listTitleTextView = view?.findViewById(R.id.title) as TextView
        listTitleTextView.setTypeface(null, Typeface.BOLD)
        listTitleTextView.text = listTitle

        val listTileImageView = view!!.findViewById(R.id.image) as ImageView
        listTileImageView.setImageResource(listImage)
        return view
    }


    override fun hasStableIds(): Boolean {
        return false
    }

    override fun isChildSelectable(
        listPosition: Int,
        expandedListPosition: Int
    ): Boolean {
        return true
    }
}