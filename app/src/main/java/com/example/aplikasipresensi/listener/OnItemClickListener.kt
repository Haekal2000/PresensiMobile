package com.example.aplikasipresensi.listener

import android.view.View

interface OnItemClickListener {
    fun onItemClick(itemView: View, position: Int)

    fun onItemLongClick(itemView: View, position: Int) : Boolean
}