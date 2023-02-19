package com.example.schoolsmart.presentation.director.subject

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.schoolsmart.base.BaseFragment
import com.example.schoolsmart.databinding.FragmentListBinding

class SubjectsFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Toast.makeText(requireContext(), "Subjects", Toast.LENGTH_SHORT).show()
    }
}