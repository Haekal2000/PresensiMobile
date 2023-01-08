package com.example.aplikasipresensi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.teacher.TeacherCourseModel

class TeacherCourseAdapterTesting(val context: Context): RecyclerView.Adapter<TeacherCourseAdapterTesting.TeacherCourseViewHolder>() {
    private val teacherCourses: MutableList<TeacherCourseModel> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeacherCourseViewHolder{
        return TeacherCourseViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_teacher_course, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeacherCourseViewHolder, position: Int) {
        holder.bindModel(teacherCourses[position])
    }

    override fun getItemCount(): Int {
        return teacherCourses.size
    }

    fun setTeacherCourses(data: List<TeacherCourseModel>) {
        teacherCourses.clear()
        teacherCourses.addAll(data)
        notifyDataSetChanged()
    }

    fun getTeacherCourses(): MutableList<TeacherCourseModel> {
        return teacherCourses
    }

    inner class TeacherCourseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTeacherCourseCode: TextView = itemView.findViewById(R.id.tv_teacher_course_code)
        val tvTeacherCourseName: TextView = itemView.findViewById(R.id.tv_teacher_course_name)
        val tvTeacherCourseType: TextView = itemView.findViewById(R.id.tv_teacher_course_type)
        val tvTeacherCourseRoom: TextView = itemView.findViewById(R.id.tv_teacher_course_room)
        val tvTeacherCourseTime: TextView = itemView.findViewById(R.id.tv_teacher_course_time)
        val btnSendEmail: Button = itemView.findViewById(R.id.btn_start_send_email)

        fun bindModel(t: TeacherCourseModel) {
            tvTeacherCourseCode.text = t.courseId
            tvTeacherCourseName.text = " "+ t.course?.name
            tvTeacherCourseType.text = " "+ "("+t.method+")"
            tvTeacherCourseRoom.text = t.room
            tvTeacherCourseTime.text = " "+ t.hours
        }

        init {
            itemView.setOnClickListener { onSelectedListener?.onItemClick(it, layoutPosition) }
        }
    }
    fun setOnSelectedListener(onSelectedListener: OnItemClickListener) {
        this.onSelectedListener = onSelectedListener
    }
}