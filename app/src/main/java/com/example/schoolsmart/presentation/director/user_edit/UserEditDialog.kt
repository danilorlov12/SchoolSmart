package com.example.schoolsmart.presentation.director.user_edit

import android.app.Dialog
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.schoolsmart.R
import com.example.schoolsmart.base.BaseBottomSheetDialog
import com.example.schoolsmart.databinding.DialogUserEditBinding
import com.example.schoolsmart.domain.entities.User
import com.example.schoolsmart.domain.entities.UserType
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class UserEditDialog(
    private val userType: UserType,
    private val user: User? = null,
) : BaseBottomSheetDialog<DialogUserEditBinding>(DialogUserEditBinding::inflate) {

    private val viewModel: UserEditViewModel by lazy {
        ViewModelProvider(this)[UserEditViewModel::class.java]
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.DialogStyle).apply {
            behavior.also {
                it.state = BottomSheetBehavior.STATE_EXPANDED
                it.skipCollapsed = true
            }
        }
    }

    override fun initBinding() = with(binding) {
        btnSave.setOnClickListener {
            if (validate()) viewModel.sendTeacherInfoToDatabase(userType.tableName)
        }
    }

    override fun initViewModel() = with(viewModel) {
        if (user != null) {
            setDataFromUser(user)
        }
    }

    private fun validate() = false
}