package com.example.schoolsmart.presentation

import android.text.Editable
import android.util.Patterns
import com.example.schoolsmart.R
import com.google.android.material.textfield.TextInputLayout

interface Validator {

    fun isValid(input: Editable?): Boolean

    class NameValidator(private val textInputLayout: TextInputLayout) : Validator {
        override fun isValid(input: Editable?): Boolean {
            with(textInputLayout) {
                error = if (input.isNullOrEmpty()) {
                    textInputLayout.context.getString(R.string.field_is_empty)
                } else if (input.length in 0..21) {
                    textInputLayout.context.getString(R.string.length_to_20)
                } else {
                    isErrorEnabled = false
                    null
                }
            }
            return textInputLayout.error.isNullOrEmpty()
        }
    }

    class EmailValidator(private val textInputLayout: TextInputLayout) : Validator {
        override fun isValid(input: Editable?): Boolean {
            with(textInputLayout) {
                error = if (input.isNullOrEmpty()) {
                    textInputLayout.context.getString(R.string.field_is_empty)
                } else if (!Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
                    textInputLayout.context.getString(R.string.invalid_format)
                } else {
                    isErrorEnabled = false
                    null
                }
            }
            return textInputLayout.error.isNullOrEmpty()
        }
    }

    class PasswordValidator(private val textInputLayout: TextInputLayout) : Validator {
        override fun isValid(input: Editable?): Boolean {
            with(textInputLayout) {
                error = if (input.isNullOrEmpty()) {
                    textInputLayout.context.getString(R.string.field_is_empty)
                } else if (input.length in 3..16) {
                    textInputLayout.context.getString(R.string.length_from_3_to_15)
                } else {
                    isErrorEnabled = false
                    null
                }
            }
            return textInputLayout.error.isNullOrEmpty()
        }
    }
}