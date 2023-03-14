package com.example.schoolsmart.presentation.director.school_member_list.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.schoolsmart.domain.entities.SchoolMember

object SchoolMembersDiffCallback : DiffUtil.ItemCallback<SchoolMember>() {

    override fun areItemsTheSame(oldItem: SchoolMember, newItem: SchoolMember): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SchoolMember, newItem: SchoolMember): Boolean {
        return oldItem == newItem
    }
}