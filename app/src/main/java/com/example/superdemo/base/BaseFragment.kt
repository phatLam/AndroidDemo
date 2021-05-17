package com.example.superdemo.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController

open class BaseFragment: Fragment() {

    protected lateinit var navHostFragment: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navHostFragment = view.findNavController()
    }

}