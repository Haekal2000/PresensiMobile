package com.example.aplikasipresensi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.R
import com.example.aplikasipresensi.databinding.ItemSessionListBinding
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.teacher.TeacherSessionModel
import java.text.SimpleDateFormat

class TeacherSessionAdapter(val context: Context): RecyclerView.Adapter<TeacherSessionAdapter.TeacherSessionViewHolder>() {
    private val teacherSession: MutableList<TeacherSessionModel> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null
    val oldFormat = SimpleDateFormat("yyyy-mm-dd")
    val newFormat = SimpleDateFormat("dd MMMM yyyy")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherSessionViewHolder {
        return TeacherSessionViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_session_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeacherSessionViewHolder, position: Int) {
        holder.bindModel(teacherSession[position])
    }

    override fun getItemCount(): Int {
        return teacherSession.size
    }

    fun setTeacherSession(data: List<TeacherSessionModel>) {
        teacherSession.clear()
        teacherSession.addAll(data)
        notifyDataSetChanged()
    }

    fun getTeacherSession(): MutableList<TeacherSessionModel> {
        return teacherSession
    }


    inner class TeacherSessionViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val bind: ItemSessionListBinding

        init {
            bind = ItemSessionListBinding.bind(itemView)
        }

        fun bindModel(ts: TeacherSessionModel) {
            val convertFormat = newFormat.format(oldFormat.parse(ts.scheduleRecord?.createdAt))
            bind.tvCourseName.text = ts.course?.name
            bind.tvDate.text = convertFormat
            bind.tvStudent.text = ts.studentRecord?.size.toString()
        }
    }
}