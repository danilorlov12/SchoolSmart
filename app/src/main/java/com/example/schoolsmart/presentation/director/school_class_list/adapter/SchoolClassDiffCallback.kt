package com.example.schoolsmart.presentation.director.school_class_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.schoolsmart.domain.entities.SchoolClass

object SchoolClassDiffCallback : DiffUtil.ItemCallback<SchoolClass>() {

    override fun areItemsTheSame(oldItem: SchoolClass, newItem: SchoolClass): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SchoolClass, newItem: SchoolClass): Boolean {
        return oldItem == newItem
    }
}