package com.example.superdemo.condition

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.*
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.superdemo.condition.adapter.FoodAdapter
import com.example.superdemo.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private lateinit var mainViewModel: MainViewModel
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val mAdapter = FoodAdapter()

    var hasInitializedRootView = false
    private var rootView: View? = null
    fun getPersistentView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            _binding = FragmentFirstBinding.inflate(inflater, container, false)
            // Inflate the layout for this fragment
            rootView = binding.root
        } else {
            // Do not inflate the layout again.
            // The returned View of onCreateView will be added into the fragment.
            // However it is not allowed to be added twice even if the parent is same.
            // So we must remove rootView from the existing parent view group
            // (it will be added back).
            (rootView?.getParent() as? ViewGroup)?.removeView(rootView)
            _binding = DataBindingUtil.getBinding(rootView!!)
        }

        return rootView
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("Phat", "onActivityCreated")
        val bundle = bundleOf(
            "B" to 20
        )
//        2 way to create viewmodel with savedstateHandel
//            mainViewModel = ViewModelProvider(this, SavedStateViewModelFactory(requireActivity().application, this, bundle)).get(MainViewModel::class.java)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(20, this, bundle)).get(MainViewModel::class.java)


    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mainViewModel.getList.observe(viewLifecycleOwner){
            Log.i("Phat", "getList = " + it)
            val list = mutableListOf<String>()
            for (i in 0..it){
                list.add("food $i")
            }
            mAdapter.list.clear()
            mAdapter.list.addAll(list.toList())
            mAdapter.notifyDataSetChanged()
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        getPersistentView(inflater, container, savedInstanceState)
        return binding.root

    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!hasInitializedRootView){
            binding.adapter = mAdapter
            binding.buttonFirst.setOnClickListener {
                val action = MainFragmentDirections.actionFirstFragmentToSecondFragment("dfds")
                findNavController().navigate(action)
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}