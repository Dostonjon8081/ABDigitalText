package com.example.abdigitaltest

import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.example.abdigitaltest.base.BaseActivity
import com.example.abdigitaltest.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun setupItems() {
        navController = findNavController(R.id.container_activity_navigation)
    }

}