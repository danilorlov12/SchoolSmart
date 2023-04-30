package com.example.schoolsmart.presentation.director.school_class_edit

import com.example.base.BaseBottomSheetDialog
import com.example.schoolsmart.databinding.DialogSchoolClassEditBinding

class SchoolClassEditDialog : BaseBottomSheetDialog<SchoolClassEditViewModel, DialogSchoolClassEditBinding>(DialogSchoolClassEditBinding::inflate) {

    override fun viewModelClass() = SchoolClassEditViewModel::class.java

    override fun initBinding() = with(binding) {
        btnSave.setOnClickListener {
            if (validate()) viewModel.sendSchoolClassInfoToDatabase()
        }
    }

    override fun initViewModel() = with(viewModel) {

    }

    private fun validate() = false
}