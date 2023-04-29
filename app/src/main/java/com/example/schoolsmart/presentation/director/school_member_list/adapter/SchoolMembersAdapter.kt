package com.example.schoolsmart.presentation.director.school_member_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolsmart.R
import com.example.base.ClickListener
import com.example.schoolsmart.domain.entities.SchoolMember

class SchoolMembersAdapter(
    private val clickListener: ClickListener<SchoolMember>,
) : ListAdapter<SchoolMember, SchoolMembersAdapter.SchoolMemberViewHolder>(SchoolMembersDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolMemberViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return SchoolMemberViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchoolMemberViewHolder, position: Int) {
        val model = getItem(position)
        with(holder) {
            tvName.text = model.getShortName()

            itemView.setOnClickListener {
                clickListener.click(model)
            }
        }
    }

    inner class SchoolMemberViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
    }
}