package com.example.schoolsmart.presentation.director.school_member_list

import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.schoolsmart.base.BaseFragment
import com.example.schoolsmart.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.SchoolMember
import com.example.schoolsmart.domain.entities.Teacher
import com.example.schoolsmart.domain.entities.UserType
import com.example.schoolsmart.presentation.director.school_member_list.adapter.SchoolMembersAdapter
import com.example.schoolsmart.presentation.director.teacher_list.adapter.TeachersAdapter
import com.example.schoolsmart.presentation.director.user_edit.UserEditDialog

class SchoolMemberListFragment : BaseFragment<FragmentListBinding>(FragmentListBinding::inflate) {

    private val viewModel: SchoolMemberListViewModel by lazy {
        ViewModelProvider(this)[SchoolMemberListViewModel::class.java]
    }

    private lateinit var _adapter: SchoolMembersAdapter

    override fun initBinding(): Unit = with(binding) {
        _adapter = SchoolMembersAdapter(object : ClickListener<SchoolMember> {
            override fun click(model: SchoolMember) {
                val dialog = UserEditDialog(UserType.SCHOOL_MEMBER, model)
                dialog.show(parentFragmentManager, "")
            }
        })
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = _adapter
        }
    }

    override fun initViewModel(): Unit = with(viewModel) {
        loadSchoolMembers()

        schoolMembers.observe(viewLifecycleOwner) {
            _adapter.submitList(it)
        }
    }
}