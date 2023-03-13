package com.example.schoolsmart.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<B: ViewBinding>(
    private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B
) : Fragment() {

    private var _binding: B? = null
    val binding: B get() = _binding!!

    protected lateinit var nav: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = bindingFactory(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nav = NavHostFragment.findNavController(this)
        initBinding()
        initViewModel()
    }

    protected abstract fun initBinding()
    protected abstract fun initViewModel()

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}