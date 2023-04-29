package com.example.presentation

import android.text.Editable
import android.util.Patterns
import com.google.android.material.textfield.TextInputLayout

interface Validator {

    fun isValid(input: Editable?): Boolean

    class NameValidator(private val textInputLayout: TextInputLayout) : Validator {
        override fun isValid(input: Editable?): Boolean {
            with(textInputLayout) {
                error = if (input.isNullOrEmpty()) {
                    "Empty field"
                } else if (input.length < 3) {
                    "Field must contains 3 or more characters"
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
                    "Empty field"
                } else if (Patterns.EMAIL_ADDRESS.matcher(input).matches()) {
                    "Invalid input"
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
                    "Empty field"
                } else if (input.length < 3) {
                    "Field length must be from 3 to 15"
                } else {
                    isErrorEnabled = false
                    null
                }
            }
            return textInputLayout.error.isNullOrEmpty()
        }
    }
}