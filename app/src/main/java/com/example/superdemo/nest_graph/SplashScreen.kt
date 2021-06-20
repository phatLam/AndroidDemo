package com.example.superdemo.nest_graph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.superdemo.R
import com.example.superdemo.base.BaseFragment
import com.example.superdemo.base.SingleClickListener
import com.example.superdemo.databinding.FragmentABinding


/**
 * A simple [Fragment] subclass.
 * Use the [SplashScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashScreen : BaseFragment() {
    private lateinit var mBinding: FragmentABinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        mBinding = FragmentABinding.inflate(inflater, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding.click = listener
    }
    private val listener = object : SingleClickListener(){
        override fun onSingleClick(v: View?) {
            when (v?.id){
                R.id.btnPlay ->{
                    navHostFragment.navigate(R.id.action_AFragment_to_BFragment)
                }

            }
        }

    }
}