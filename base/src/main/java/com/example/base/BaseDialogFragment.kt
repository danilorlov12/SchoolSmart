package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseDialogFragment<VM: BaseViewModel, B: ViewBinding>(
    private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B
) : AppCompatDialogFragment() {

    protected lateinit var viewModel: VM

    private var _binding: B? = null
    val binding: B get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[viewModelClass()]
    }

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingFactory(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initBinding()
    }

    protected abstract fun viewModelClass(): Class<VM>
    protected abstract fun initViewModel()
    protected abstract fun initBinding()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}