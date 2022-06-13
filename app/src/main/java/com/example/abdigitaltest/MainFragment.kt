package com.example.abdigitaltest

import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.abdigitaltest.base.BaseFragment
import com.example.abdigitaltest.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment: BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    override fun onResume() {
        super.onResume()
        getBaseActivity {
            it.bottomNavController = Navigation.findNavController(
                requireActivity(),
                R.id.container_main_navigation
            )
            NavigationUI.setupWithNavController(
                binding.bottomNavigationView,
                it.bottomNavController!!
            )
        }
    }
}