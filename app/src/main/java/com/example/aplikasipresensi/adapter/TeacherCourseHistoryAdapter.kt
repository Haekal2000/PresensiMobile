package com.example.aplikasipresensi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.databinding.ItemCourseBinding
import com.example.aplikasipresensi.databinding.ItemStudentAttendanceBinding
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.course.StudentModel
import com.example.aplikasipresensi.model.teacher.TeacherCourseHistoryModel

class TeacherCourseHistoryAdapter(val context: Context) : RecyclerView.Adapter<TeacherCourseHistoryAdapter.TeacherCourseHistoryAdapterViewHolder>() {
    private val teacherCourseHistory: MutableList<TeacherCourseHistoryModel> = mutableListOf()
    private val student: MutableList<StudentModel> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeacherCourseHistoryAdapterViewHolder {
        return TeacherCourseHistoryAdapterViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_student_attendance, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeacherCourseHistoryAdapterViewHolder, position: Int) {
        holder.bindModel(student[position])
    }

    override fun getItemCount(): Int {
        return teacherCourseHistory.size
    }

    fun setTeacherCourseHistory(data: List<TeacherCourseHistoryModel>) {
        teacherCourseHistory.clear()
        teacherCourseHistory.addAll(data)
        notifyDataSetChanged()
    }

    fun getTeacherCourseHistory(): MutableList<TeacherCourseHistoryModel> {
        return teacherCourseHistory
    }

    inner class TeacherCourseHistoryAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bind: ItemStudentAttendanceBinding

        init {
            bind = ItemStudentAttendanceBinding.bind(itemView)
        }

        fun bindModel(tc: StudentModel) {
            bind.tvStudentId.text = tc.id
            bind.tvStudentName.text = tc.name
        }
    }
}