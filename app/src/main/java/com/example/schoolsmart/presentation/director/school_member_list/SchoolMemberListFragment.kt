package com.example.schoolsmart.presentation.director.school_member_list

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.base.BaseFragment
import com.example.base.ClickListener
import com.example.schoolsmart.databinding.FragmentListBinding
import com.example.schoolsmart.domain.entities.SchoolMember
import com.example.schoolsmart.domain.entities.UserType
import com.example.schoolsmart.presentation.director.school_member_list.adapter.SchoolMembersAdapter
import com.example.schoolsmart.presentation.director.user_edit.UserEditDialog

class SchoolMemberListFragment : BaseFragment<SchoolMemberListViewModel, FragmentListBinding>(FragmentListBinding::inflate) {

    override fun viewModelClass() = SchoolMemberListViewModel::class.java

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