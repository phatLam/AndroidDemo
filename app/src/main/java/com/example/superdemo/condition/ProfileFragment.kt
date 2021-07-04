package com.example.superdemo.condition

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.superdemo.R
import com.example.superdemo.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ProfileFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val viewModel: UserViewModel by activityViewModels()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navController = findNavController()
        val currentNavBackStackEntry = navController.currentBackStackEntry!!
        val savedStateHandle = currentNavBackStackEntry.savedStateHandle
        savedStateHandle.getLiveData<Boolean>(LoginFragment.LOGIN_SUCCESSFUL).observe(currentNavBackStackEntry){
            if (!it){
                val startDestination = navController.graph.startDestination
                val navOptions = NavOptions.Builder()
                    .setPopUpTo(startDestination,true).build()
                navController.navigate(startDestination, null,  navOptions)
            }
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }
    val args: ProfileFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val userId = args.userId
        viewModel.isLogin.observe(viewLifecycleOwner){
            if (it){
                Log.i("PHat", "success")
            } else {
                findNavController().navigate(R.id.loginFragment)
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}