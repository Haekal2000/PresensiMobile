package com.example.aplikasipresensi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.databinding.ItemCourseBinding
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.course.CourseModel

class CourseAdapterTesting(val context: Context) :
    RecyclerView.Adapter<CourseAdapterTesting.CourseAdapterTestingViewHolder>() {
    private val course: MutableList<CourseModel> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseAdapterTestingViewHolder {
        return CourseAdapterTestingViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_course, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseAdapterTestingViewHolder, position: Int) {
        holder.bindModel(course[position])
    }

    override fun getItemCount(): Int {
        return course.size
    }

    fun setCourse(data: List<CourseModel>) {
        course.clear()
        course.addAll(data)
        notifyDataSetChanged()
    }

    fun getCourse(): MutableList<CourseModel> {
        return course
    }

    inner class CourseAdapterTestingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bind: ItemCourseBinding

        init {
            bind = ItemCourseBinding.bind(itemView)
        }

        fun bindModel(c: CourseModel) {

            bind.tvCourseCode.text = c.id
            bind.tvCourseName.text = c.course?.name
            bind.tvDay.text = c.day
            bind.tvHours.text = c.hours
            bind.tvRoom.text = c.room
        }

        init {
            itemView.setOnClickListener { onSelectedListener?.onItemClick(it, layoutPosition) }
        }
    }

    fun setOnSelectedListener(onSelectedListener: OnItemClickListener) {
        this.onSelectedListener = onSelectedListener
    }
}