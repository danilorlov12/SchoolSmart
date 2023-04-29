package com.example.schoolsmart.presentation.director.subject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.schoolsmart.R
import com.example.base.ClickListener
import com.example.schoolsmart.domain.entities.Subject

class SubjectAdapter(
    private val clickListener: ClickListener<Subject>
) : ListAdapter<Subject, SubjectAdapter.SubjectViewHolder>(SubjectDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubjectViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_subject, parent, false)
        return SubjectViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubjectViewHolder, position: Int) {
        val model = getItem(position)
        with(holder) {
            tvName.text = model.name

            itemView.setOnClickListener {
                clickListener.click(model)
            }
        }
    }

    inner class SubjectViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvName)
    }
}