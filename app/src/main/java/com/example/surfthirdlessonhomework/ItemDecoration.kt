package com.example.surfthirdlessonhomework

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(private val space: Int?, private val leftMargin: Int?, private val rightMargin: Int?) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        if (parent.getChildAdapterPosition(view) != 0) {
            if (space != null) {
                outRect.top = space
            }

        }
        if (leftMargin != null) {
            outRect.left = leftMargin
        }
        if (rightMargin != null) {
            outRect.right = rightMargin
        }
    }

}
