package com.example.abdigitaltest.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding>(val bindingFactory: (LayoutInflater) -> B) :
    AppCompatActivity() {
    lateinit var binding: B
    var navController: NavController? = null
    var bottomNavController: NavController? = null


    var baseActivity: BaseActivity<B>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = bindingFactory(layoutInflater)


        setContentView(binding.root)
        setupItems()

        baseActivity = this

    }


    abstract fun setupItems()

}