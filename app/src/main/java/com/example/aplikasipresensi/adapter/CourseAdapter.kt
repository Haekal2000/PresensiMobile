package com.example.aplikasipresensi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.databinding.ItemCourseBinding
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.course.CourseModel

class CourseAdapter(val context: Context): RecyclerView.Adapter<CourseAdapter.CourseViewHolder>() {
    private val course: MutableList<CourseModel> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
        return CourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_course, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseAdapter.CourseViewHolder, position: Int) {
        holder.bindModel(course[position])
        //tambahan
//        holder.setIsRecyclable(false)
//        holder.bindModel(course[0])
    }

    //tambahan
//    override fun getItemViewType(position: Int): Int {
//        return position
//    }

    override fun getItemCount(): Int {
        return course.size
    }

    //tambahan
//    override fun getItemId(position: Int): Long {
//        return position.toLong()
//    }

    fun setCourse(data: List<CourseModel>) {
        course.clear()
        course.addAll(data)
        notifyDataSetChanged()
//        notifyItemChanged(0)
    }

    fun getCourse(): MutableList<CourseModel> {
        return course
    }

    inner class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCourseCode: TextView = itemView.findViewById(R.id.tv_course_code)
        val tvCourseName: TextView = itemView.findViewById(R.id.tv_course_name)
        val tvDay: TextView = itemView.findViewById(R.id.tv_day)
        val tvHours: TextView = itemView.findViewById(R.id.tv_hours)
        val tvRoom: TextView = itemView.findViewById(R.id.tv_room)
//        private val bind: ItemCourseBinding
//        init {
//            bind = ItemCourseBinding.bind(itemView)
//        }

        fun bindModel(c: CourseModel) {
            tvCourseCode.text = c.id
            tvCourseName.text = c.name
            tvDay.text = c.day
            tvHours.text = c.hours
            tvRoom.text = c.room

//            bind.tvCourseCode.text = c.id
//            bind.tvCourseName.text = c.name
//            bind.tvDay.text = c.day
//            bind.tvHours.text = c.hours
//            bind.tvRoom.text = c.room
        }

        init {
            itemView.setOnClickListener { onSelectedListener?.onItemClick(it, layoutPosition) }
        }
    }

    fun setOnSelectedListener(onSelectedListener: OnItemClickListener) {
        this.onSelectedListener = onSelectedListener
    }
}