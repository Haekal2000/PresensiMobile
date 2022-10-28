/*
package com.example.aplikasipresensi.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.aplikasipresensi.listener.OnItemClickListener
import com.example.aplikasipresensi.model.student.StudentModel

class StudentAdapter(val context: Context): RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {
    private val student: MutableList<StudentModel> = mutableListOf()
    private var onSelectedListener: OnItemClickListener? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentAdapter.StudentViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return student.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {

    }

    fun setStudent(data: List<StudentModel>) {
        student.clear()
        student.addAll(data)
        notifyDataSetChanged()
    }

    fun getStudent(): MutableList<StudentModel> {
        return student
    }

    inner class StudentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }
}*/
