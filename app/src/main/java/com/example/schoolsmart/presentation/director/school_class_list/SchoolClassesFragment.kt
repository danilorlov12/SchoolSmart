package com.example.schoolsmart.presentation.director.school_class_list

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolsmart.R
import com.example.schoolsmart.base.BaseFragment
import com.example.schoolsmart.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.SchoolClass
import com.example.schoolsmart.presentation.director.school_class_list.adapter.SchoolClassesAdapter
import com.example.schoolsmart.presentation.director.school_member_list.SchoolMemberListFragment

class SchoolClassesFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: SchoolClassesViewModel by lazy {
        ViewModelProvider(this)[SchoolClassesViewModel::class.java]
    }

    private lateinit var _adapter: SchoolClassesAdapter

    override fun initBinding(): Unit = with(binding) {
        _adapter = SchoolClassesAdapter(object : ClickListener<SchoolClass> {
            override fun click(model: SchoolClass) {
//                this@SchoolClassesFragment.requireActivity().supportFragmentManager
//                    .beginTransaction().replace(R.id.fragmentContainer, SchoolMemberListFragment(), SchoolMemberListFragment().name())
//                    .commit()
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