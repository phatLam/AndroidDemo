package com.example.superdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.superdemo.base.ShareReference
import com.example.superdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        if (!ShareReference.share.isLogin){
           navController.navController.navigate(R.id.action_matchFragment_to_register_nav)
        }

    }
}