package com.example.schoolsmart.presentation.director.teacher_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.schoolsmart.domain.entities.Teacher

object TeachersDiffCallback : DiffUtil.ItemCallback<Teacher>() {

    override fun areItemsTheSame(oldItem: Teacher, newItem: Teacher): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Teacher, newItem: Teacher): Boolean {
        return oldItem == newItem
    }
}