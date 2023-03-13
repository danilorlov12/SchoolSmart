package com.example.schoolsmart.presentation.director.teacher_edit

import androidx.lifecycle.ViewModelProvider
import com.example.schoolsmart.base.BaseBottomSheetDialog
import com.example.schoolsmart.databinding.FragmentTeacherEditBinding
import com.example.schoolsmart.domain.entities.Teacher

class TeacherEditDialog(
    private val teacher: Teacher? = null
) : BaseBottomSheetDialog<FragmentTeacherEditBinding>(FragmentTeacherEditBinding::inflate) {

    private val viewModel: TeacherEditViewModel by lazy {
        ViewModelProvider(this)[TeacherEditViewModel::class.java]
    }

    override fun initBinding() = with(binding) {

    }

    override fun initViewModel() = with(viewModel) {

    }
}