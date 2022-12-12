package com.example.aplikasipresensi.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.aplikasipresensi.databinding.ItemCourseBinding
import com.example.aplikasipresensi.model.course.CourseModel

class CourseAdapter2(val courses: ArrayList<CourseModel>) : Adapter<CourseAdapter2.CourseViewHolder>() {

    private lateinit var itemDataListener: ItemDataListener

    inner class CourseViewHolder(itemView: View) : ViewHolder(itemView) {
        private lateinit var itemCourseBinding: ItemCourseBinding
        init {
            itemCourseBinding = ItemCourseBinding.bind(itemView)
        }
        fun setItemData(course: CourseModel) {

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        holder.setItemData(courses[position])
        holder.itemView.setOnClickListener {
            itemDataListener.itemDataClicked(courses[position])
        }
    }

    override fun getItemCount(): Int {
        return courses.size
    }

    fun setItemDataListener(itemDataListener: ItemDataListener) {
        this.itemDataListener = itemDataListener
    }

    interface ItemDataListener {
        fun itemDataClicked(course: CourseModel)
    }
}