package com.example.schoolsmart.presentation.director.school_class_list

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.BaseFragment
import com.example.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.SchoolClass
import com.example.schoolsmart.presentation.director.school_class_list.adapter.SchoolClassesAdapter

class SchoolClassesFragment : BaseFragment<SchoolClassesViewModel, FragmentListBinding>(FragmentListBinding::inflate) {

    override fun viewModelClass() = SchoolClassesViewModel::class.java

    private lateinit var _adapter: SchoolClassesAdapter

    override fun initBinding(): Unit = with(binding) {
        _adapter = SchoolClassesAdapter(object : ClickListener<SchoolClass> {
            override fun click(model: SchoolClass) {
                val action = SchoolClassesFragmentDirections.toSchoolClassFragment(model.id)
                nav.navigate(action)
            }
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = _adapter
        }
    }

    override fun initViewModel() = with(viewModel) {
        schoolClasses.observe(viewLifecycleOwner) {
            _adapter.submitList(it)
        }
    }
}