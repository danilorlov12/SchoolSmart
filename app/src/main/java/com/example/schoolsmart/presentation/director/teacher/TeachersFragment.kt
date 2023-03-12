package com.example.schoolsmart.presentation.director.teacher

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolsmart.base.BaseFragment
import com.example.schoolsmart.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.Teacher
import com.example.schoolsmart.presentation.director.teacher.adapter.TeachersAdapter

class TeachersFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: TeachersViewModel by lazy {
        ViewModelProvider(this)[TeachersViewModel::class.java]
    }

    private lateinit var _adapter: TeachersAdapter

    override fun initBinding(): Unit = with(binding) {
        _adapter = TeachersAdapter(object : ClickListener<Teacher> {
            override fun click(model: Teacher) {
                //TODO Navigate to TeacherDetailsFragment
            }
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = _adapter
        }
    }

    override fun initViewModel() = with(viewModel) {
        loadTeachers()

        teachers.observe(viewLifecycleOwner) {
            _adapter.submitList(it)
        }
    }
}