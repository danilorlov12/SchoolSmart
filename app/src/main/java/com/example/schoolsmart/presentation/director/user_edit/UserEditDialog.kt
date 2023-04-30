package com.example.schoolsmart.presentation.director.user_edit

import android.app.Dialog
import android.os.Bundle
import androidx.core.widget.doOnTextChanged
import com.example.base.BaseBottomSheetDialog
import com.example.schoolsmart.presentation.Validator
import com.example.schoolsmart.R
import com.example.schoolsmart.databinding.DialogUserEditBinding
import com.example.schoolsmart.domain.entities.User
import com.example.schoolsmart.domain.entities.UserType
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class UserEditDialog(
    private val userType: UserType,
    private val user: User? = null,
) : BaseBottomSheetDialog<UserEditViewModel, DialogUserEditBinding>(DialogUserEditBinding::inflate) {

    override fun viewModelClass() = UserEditViewModel::class.java

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), R.style.DialogStyle).apply {
            behavior.let {
                it.state = BottomSheetBehavior.STATE_EXPANDED
                it.skipCollapsed = true
            }
        }
    }

    override fun initViewModel() = Unit

    override fun initBinding() = with(binding) {
        etFirstName.doOnTextChanged { text, _, _, _ ->
            viewModel.firstName.value = text.toString()
        }
        etFirstName.setText(user?.firstName ?: "")
        etLastName.doOnTextChanged { text, _, _, _ ->
            viewModel.lastName.value = text.toString()
        }
        etLastName.setText(user?.lastName ?: "")
        etMiddleName.doOnTextChanged { text, _, _, _ ->
            viewModel.middleName.value = text.toString()
        }
        etMiddleName.setText(user?.middleName ?: "")
        etEmail.doOnTextChanged { text, _, _, _ ->
            viewModel.email.value = text.toString()
        }
        etEmail.setText(user?.email ?: "")
        etPassword.doOnTextChanged { text, _, _, _ ->
            viewModel.password.value = text.toString()
        }
        etPassword.setText(user?.password)
        btnSave.setOnClickListener {
            if (validate()) viewModel.prepareAndSendUserInfo(userType.tableName)
        }
    }

    private fun validate(): Boolean {
        val validatorResults = listOf(
            Validator.NameValidator(binding.tilFirstName).isValid(binding.etFirstName.text),
            Validator.NameValidator(binding.tilLastName).isValid(binding.etLastName.text),
            Validator.NameValidator(binding.tilMiddleName).isValid(binding.etMiddleName.text),
            Validator.EmailValidator(binding.tilEmail).isValid(binding.etEmail.text),
            Validator.PasswordValidator(binding.tilPassword).isValid(binding.etPassword.text)
        )
        return validatorResults.all { it }
    }
}