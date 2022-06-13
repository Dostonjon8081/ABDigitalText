package com.example.abdigitaltest.core_fragment.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.abdigitaltest.base.BaseFragment
import com.example.abdigitaltest.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

  private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel
//       homeViewModel.getCharacters()
    }
}