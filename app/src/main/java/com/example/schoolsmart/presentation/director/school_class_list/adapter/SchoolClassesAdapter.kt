package com.example.schoolsmart.presentation.director.school_class_list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolsmart.R
import com.example.schoolsmart.base.ClickListener
import com.example.schoolsmart.domain.entities.SchoolClass

class SchoolClassesAdapter(
    private val clickListener: ClickListener<SchoolClass>
) : ListAdapter<SchoolClass, SchoolClassesAdapter.SchoolClassViewHolder>(SchoolClassDiffCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolClassViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_school_class, parent, false)
        return SchoolClassViewHolder(view)
    }

    override fun onBindViewHolder(holder: SchoolClassViewHolder, position: Int) {
        val model = getItem(position)
        with(holder) {
            tvName.text = model.name
            tvSchoolMemberCount.text = "0"
            itemView.setOnClickListener {
                clickListener.click(model)
            }
        }
    }

    inner class SchoolClassViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
        val tvSchoolMemberCount: TextView = itemView.findViewById(R.id.tvSchoolMemberCount)
    }
}