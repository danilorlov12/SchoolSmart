package com.example.schoolsmart.presentation.director.subject.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.schoolsmart.domain.entities.Subject

object SubjectDiffCallback : DiffUtil.ItemCallback<Subject>() {

    override fun areItemsTheSame(oldItem: Subject, newItem: Subject): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Subject, newItem: Subject): Boolean {
        return oldItem == newItem
    }
}