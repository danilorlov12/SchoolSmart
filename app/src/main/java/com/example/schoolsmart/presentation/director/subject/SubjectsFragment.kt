package com.example.schoolsmart.presentation.director.subject

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolsmart.base.BaseFragment
import com.example.schoolsmart.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.Subject
import com.example.schoolsmart.presentation.director.subject.adapter.SubjectAdapter

class SubjectsFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: SubjectsViewModel by lazy {
        ViewModelProvider(this)[SubjectsViewModel::class.java]
    }

    private lateinit var _adapter: SubjectAdapter

    override fun initBinding(): Unit = with(binding) {
        _adapter = SubjectAdapter(object : ClickListener<Subject> {
            override fun click(model: Subject) {
                TODO("Not yet implemented")
            }
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = _adapter
        }
    }

    override fun initViewModel() = with(viewModel) {
        loadSubjects()

        subjects.observe(viewLifecycleOwner) {
            _adapter.submitList(it)
        }
    }
}