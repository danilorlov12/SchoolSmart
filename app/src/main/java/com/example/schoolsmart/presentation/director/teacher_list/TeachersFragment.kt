package com.example.schoolsmart.presentation.director.teacher_list

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.BaseFragment
import com.example.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.Teacher
import com.example.schoolsmart.domain.entities.UserType
import com.example.schoolsmart.presentation.director.teacher_list.adapter.TeachersAdapter
import com.example.schoolsmart.presentation.director.user_edit.UserEditDialog

class TeachersFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: TeachersViewModel by lazy {
        ViewModelProvider(this)[TeachersViewModel::class.java]
    }

    private lateinit var _adapter: TeachersAdapter

    override fun initBinding(): Unit = with(binding) {
        binding.btnCreate.setOnClickListener {
            val dialog = UserEditDialog(UserType.TEACHER)
            dialog.show(parentFragmentManager, "")
        }
        _adapter = TeachersAdapter(object : ClickListener<Teacher> {
            override fun click(model: Teacher) {
                val dialog = UserEditDialog(UserType.TEACHER, model)
                dialog.show(parentFragmentManager, "")
            }
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = _adapter
        }
    }

    override fun initViewModel() = with(viewModel) {
        teachers.observe(viewLifecycleOwner) {
            _adapter.submitList(it)
        }
    }
}