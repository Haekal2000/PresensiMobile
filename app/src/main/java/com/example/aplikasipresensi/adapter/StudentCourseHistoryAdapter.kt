package com.example.aplikasipresensi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.databinding.ItemAttendanceDetailBinding
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.course.StudentCourseHistoryModel
import java.text.SimpleDateFormat

class StudentCourseHistoryAdapter(val context: Context) : RecyclerView.Adapter<StudentCourseHistoryAdapter.StudentCourseHistoryAdapterViewHolder>() {
    private val studentCourseHistory: MutableList<StudentCourseHistoryModel> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null
    val oldFormat = SimpleDateFormat("yyyy-mm-dd")
    val newFormat = SimpleDateFormat("dd MMMM yyyy")

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentCourseHistoryAdapterViewHolder {
        return StudentCourseHistoryAdapterViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_attendance_detail, parent, false)
        )
    }

    override fun onBindViewHolder(holder: StudentCourseHistoryAdapterViewHolder, position: Int) {
        holder.bindModel(studentCourseHistory[position])
    }

    override fun getItemCount(): Int {
        return studentCourseHistory.size
    }

    fun setStudentCourseHistory(data: List<StudentCourseHistoryModel>) {
        studentCourseHistory.clear()
        studentCourseHistory.addAll(data)
        notifyDataSetChanged()
    }

    fun getStudentCourseHistory(): MutableList<StudentCourseHistoryModel> {
        return studentCourseHistory
    }

    inner class StudentCourseHistoryAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val bind: ItemAttendanceDetailBinding

        init {
            bind = ItemAttendanceDetailBinding.bind(itemView)
        }

        fun bindModel(sh: StudentCourseHistoryModel) {
            val convertFormat = newFormat.format(oldFormat.parse(sh.acceptDate))
            bind.tvDate.text = convertFormat
            bind.tvCourseName.text = sh.courseId
        }
    }
}