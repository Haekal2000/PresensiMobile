package com.example.aplikasipresensi.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.teacher.TeacherCourseModel

class TeacherCourseAdapter(val listTeacherCourse: MutableList<TeacherCourseModel>): RecyclerView.Adapter<TeacherCourseAdapter.TeacherCourseViewHolder>() {
    private val teacherCourse: MutableList<TeacherCourseModel> = mutableListOf()
    private lateinit var itemDataListener: ItemDataListener
//    private var itemDataListener: ItemDataListener? = null
//    private lateinit var buttonDataListener: ButtonDataListener
    private var buttonDataListener: ButtonDataListener? = null
    private var onSelectedListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TeacherCourseViewHolder {
        return TeacherCourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_teacher_course, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeacherCourseAdapter.TeacherCourseViewHolder, position: Int) {
        holder.bindModel(listTeacherCourse[position])
        holder.itemView.setOnClickListener {
//            itemDataListener = ItemDataListener
            itemDataListener.itemDataClicked(listTeacherCourse[position])
        }
        holder.btnSendEmail.setOnClickListener {
            buttonDataListener?.buttonDataClicked(listTeacherCourse[position])
        }
    }

    override fun getItemCount(): Int {
        return listTeacherCourse.size
    }

    fun setItemDataListener(itemDataListener: ItemDataListener){
        this.itemDataListener = itemDataListener
    }

    interface ItemDataListener {
        fun itemDataClicked(teacherCourse: TeacherCourseModel)
    }

    fun setButtonDataListener(buttonDataListener: ButtonDataListener){
        this.buttonDataListener = buttonDataListener
    }

    interface ButtonDataListener {
        fun buttonDataClicked(teacherCourse: TeacherCourseModel)
    }

    fun setTeacherCourse(data: List<TeacherCourseModel>) {
        listTeacherCourse.clear()
        listTeacherCourse.addAll(data)
        notifyDataSetChanged()
//        notifyItemChanged(0)
    }

    fun getTeacherCourse(): MutableList<TeacherCourseModel> {
        return listTeacherCourse
    }

    inner class TeacherCourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTeacherCourseCode: TextView = itemView.findViewById(R.id.tv_teacher_course_code)
        val tvTeacherCourseName: TextView = itemView.findViewById(R.id.tv_teacher_course_name)
        val tvTeacherCourseType: TextView = itemView.findViewById(R.id.tv_teacher_course_type)
        val tvTeacherCourseRoom: TextView = itemView.findViewById(R.id.tv_teacher_course_room)
        val tvTeacherCourseTime: TextView = itemView.findViewById(R.id.tv_teacher_course_time)
        val btnSendEmail: Button = itemView.findViewById(R.id.btn_start_send_email)

        fun bindModel(t: TeacherCourseModel) {
            tvTeacherCourseCode.text = t.courseId
            tvTeacherCourseName.text = " "+ t.course?.name
            tvTeacherCourseType.text = " "+ t.method
            tvTeacherCourseRoom.text = t.room
            tvTeacherCourseTime.text = " "+ t.hours
//            btnSendEmail.setO
        }

        init {
            itemView.setOnClickListener { onSelectedListener?.onItemClick(it, layoutPosition) }
        }
    }

    fun setOnSelectedListener(onSelectedListener: OnItemClickListener) {
        this.onSelectedListener = onSelectedListener
    }
}