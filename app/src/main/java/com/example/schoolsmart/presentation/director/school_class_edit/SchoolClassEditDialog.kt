package com.example.schoolsmart.presentation.director.school_class_edit

import androidx.lifecycle.ViewModelProvider
import com.example.schoolsmart.base.BaseBottomSheetDialog
import com.example.schoolsmart.databinding.DialogSchoolClassEditBinding

class SchoolClassEditDialog : BaseBottomSheetDialog<DialogSchoolClassEditBinding>(DialogSchoolClassEditBinding::inflate) {

    private val viewModel: SchoolClassEditViewModel by lazy {
        ViewModelProvider(this)[SchoolClassEditViewModel::class.java]
    }

    override fun initBinding() = with(binding) {
        btnSave.setOnClickListener {
            if (validate()) viewModel.sendSchoolClassInfoToDatabase()
        }
    }

    override fun initViewModel() = with(viewModel) {

    }

    private fun validate() = false
}