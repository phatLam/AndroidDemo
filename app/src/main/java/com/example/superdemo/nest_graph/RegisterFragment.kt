package com.example.superdemo.nest_graph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superdemo.R
import com.example.superdemo.base.BaseFragment
import com.example.superdemo.base.ShareReference
import com.example.superdemo.base.SingleClickListener
import com.example.superdemo.databinding.FragmentBBinding

class RegisterFragment : BaseFragment() {

    private lateinit var mBinding: FragmentBBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentBBinding.inflate(inflater, container, false)
        mBinding.click = listener
        return mBinding.root
    }



    private val listener = object : SingleClickListener() {
        override fun onSingleClick(v: View?) {
            when (v?.id) {
                R.id.btnRegister -> {
                    if (mBinding.edtUserName.text?.isEmpty() == false) {
                        ShareReference.share.isLogin = true
                        navHostFragment.navigate(R.id.action_global_matchFragment)
                    }
                }

            }
        }

    }
}