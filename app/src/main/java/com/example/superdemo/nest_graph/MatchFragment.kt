package com.example.superdemo.nest_graph

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superdemo.R
import com.example.superdemo.base.BaseFragment
import com.example.superdemo.base.SingleClickListener
import com.example.superdemo.databinding.FragmentMatchBinding


/**
 * A simple [Fragment] subclass.
 * Use the [MatchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MatchFragment : BaseFragment() {

    private lateinit var mBinding: FragmentMatchBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = FragmentMatchBinding.inflate(inflater, container, false )
        mBinding.click = listener
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("Phat", "dfdfds")

    }
    private val listener = object : SingleClickListener() {
        override fun onSingleClick(v: View?) {
            when (v?.id) {
                R.id.btnLogout -> {

                }
                R.id.btnNext ->{
                    navHostFragment.navigate(R.id.action_matchFragment_to_inGameFragment)
                }
            }
        }

    }
}