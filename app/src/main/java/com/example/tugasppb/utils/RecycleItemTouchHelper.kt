package com.example.tugasppb.utils

import android.graphics.Canvas
import android.view.View
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.tugasppb.adapter.RVListBerita
import kotlinx.android.synthetic.main.item_berita.view.*

class RecycleItemTouchHelper(
    var dragDirs: Int,
    var swipeDirs: Int,
    var listener: RecyclerItemHelperTouchHelperListener
) :
    ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        listener?.onSwiped(viewHolder, direction, viewHolder.adapterPosition)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        val foregroundView: View = (viewHolder as RVListBerita.MyViewHolder).view.view_foregound
        getDefaultUIUtil().onDraw(
            c,
            recyclerView,
            foregroundView,
            dX,
            dY,
            actionState,
            isCurrentlyActive
        )
    }

//    override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
//        val foregroundView: View = (viewHolder as RVListBerita.MyViewHolder).view.view_foregound
//        getDefaultUIUtil().clearView(foregroundView)
//    }

//    override fun onChildDrawOver(
//        c: Canvas,
//        recyclerView: RecyclerView,
//        viewHolder: RecyclerView.ViewHolder?,
//        dX: Float,
//        dY: Float,
//        actionState: Int,
//        isCurrentlyActive: Boolean
//    ) {
//        val foregroundView: View = (viewHolder as RVListBerita.MyViewHolder).view.view_foregound
//        getDefaultUIUtil().onDrawOver(
//            c,
//            recyclerView,
//            foregroundView,
//            dX,
//            dY,
//            actionState,
//            isCurrentlyActive
//        )
//    }
//
//    override fun onSelectedChanged(viewHolder: RecyclerView.ViewHolder?, actionState: Int) {
//        if (viewHolder !== null) {
//            val foregroundView: View = (viewHolder as RVListBerita.MyViewHolder).view.view_foregound
//            getDefaultUIUtil().onSelected(foregroundView)
//        }
//    }
//
//    override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
//        return super.convertToAbsoluteDirection(flags, layoutDirection)
//    }
}

interface RecyclerItemHelperTouchHelperListener {
    fun onSwiped(
        viewHolder: RecyclerView.ViewHolder,
        direction: Int,
        position: Int
    )
}
