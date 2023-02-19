package com.example.schoolsmart.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

abstract class BaseViewModelFactory<T : ViewModel> : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(viewModelClass())) {
            return createViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

    protected abstract fun createViewModel(): T
    protected abstract fun viewModelClass(): Class<T>
}