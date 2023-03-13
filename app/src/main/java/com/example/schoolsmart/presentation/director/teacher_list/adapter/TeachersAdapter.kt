package com.example.schoolsmart.presentation.director.teacher_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolsmart.R
import com.example.schoolsmart.base.ClickListener
import com.example.schoolsmart.domain.entities.Teacher

class TeachersAdapter(
    private val clickListener: ClickListener<Teacher>,
) : ListAdapter<Teacher, TeachersAdapter.TeacherViewHolder>(TeachersDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return TeacherViewHolder(view)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val model = getItem(position)
        with(holder) {
            tvName.text = model.getShortName()

            itemView.setOnClickListener {
                clickListener.click(model)
            }
        }
    }

    inner class TeacherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
    }
}