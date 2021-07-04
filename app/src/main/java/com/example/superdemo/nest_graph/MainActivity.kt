package com.example.superdemo.nest_graph

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.superdemo.R
import com.example.superdemo.base.ShareReference
import com.example.superdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val action = intent?.action
        val data = intent?.data
        Log.i("Phat", "action =" + action)
        Log.i("Phat", "data =" + data)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        if (!ShareReference.share.isLogin){
           navController.navController.navigate(R.id.action_matchFragment_to_register_nav)
        }

    }
}