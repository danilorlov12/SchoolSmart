package com.example.schoolsmart.presentation.director.user_edit

import androidx.lifecycle.ViewModelProvider
import com.example.schoolsmart.base.BaseBottomSheetDialog
import com.example.schoolsmart.databinding.FragmentTeacherEditBinding
import com.example.schoolsmart.domain.entities.User

class UserEditDialog(
    private val userType: String,
    private val user: User? = null,
) : BaseBottomSheetDialog<FragmentTeacherEditBinding>(FragmentTeacherEditBinding::inflate) {

    private val viewModel: UserEditViewModel by lazy {
        ViewModelProvider(this)[UserEditViewModel::class.java]
    }

    override fun initBinding() = with(binding) {
        btnSave.setOnClickListener {
            if (validate()) viewModel.sendTeacherInfoToDatabase(userType)
        }
    }

    override fun initViewModel() = with(viewModel) {

    }

    private fun validate() = false
}