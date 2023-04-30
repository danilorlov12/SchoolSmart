package com.example.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VM: BaseViewModel, B: ViewBinding>(
    private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B
) : Fragment() {

    protected lateinit var viewModel: VM

    private var _binding: B? = null
    val binding: B get() = _binding!!

    protected lateinit var nav: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[viewModelClass()]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingFactory(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav = NavHostFragment.findNavController(this)
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