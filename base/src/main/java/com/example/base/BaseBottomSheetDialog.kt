package com.example.base

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

abstract class BaseBottomSheetDialog<VM: BaseViewModel, B : ViewBinding>(
    bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B
) : BaseDialogFragment<VM, B>(bindingFactory) {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return BottomSheetDialog(requireContext(), theme)
    }
}