package com.example.schoolsmart.presentation.director.school_class

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolsmart.base.BaseFragment
import com.example.schoolsmart.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.SchoolClass
import com.example.schoolsmart.presentation.director.school_class.adapter.SchoolClassesAdapter

class SchoolClassesFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: SchoolClassesViewModel by lazy {
        ViewModelProvider(this)[SchoolClassesViewModel::class.java]
    }

    private lateinit var _adapter: SchoolClassesAdapter

    override fun initBinding(): Unit = with(binding) {
        _adapter = SchoolClassesAdapter(object : ClickListener<SchoolClass> {
            override fun click(model: SchoolClass) {
                TODO("Not yet implemented")
            }
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = _adapter
        }
    }

    override fun initViewModel() = with(viewModel) {
        loadSchoolClasses()

        schoolClasses.observe(viewLifecycleOwner) {
            _adapter.submitList(it)
        }
    }
}