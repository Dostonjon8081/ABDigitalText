package com.example.abdigitaltest.core_fragment.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.abdigitaltest.base.BaseFragment
import com.example.abdigitaltest.databinding.FragmentHomeBinding
import com.example.abdigitaltest.util.extension.logd
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    IClickCharacterItem {

    private val homeViewModel: HomeViewModel by viewModels()
    private val rvList = mutableListOf<ResultCharacterDto>()
    private val characterAdapter by lazy(LazyThreadSafetyMode.NONE) { CharacterAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.charactersRv.adapter = characterAdapter

        homeViewModel
        homeViewModel.loading.observe(viewLifecycleOwner) {
            binding.homePb.isVisible = it
        }
        homeViewModel.charactersResponseApi.observe(viewLifecycleOwner) { dto ->
            characterAdapter.initDat(dto.results!!)
        }

        homeViewModel.searchCharacter.observe(viewLifecycleOwner){
            characterAdapter.initDat(it.results!!)
        }

        characterAdapter.initClick(this)

        binding.searchCharacter.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                homeViewModel.getCharacters()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                homeViewModel.searchCharacter(newText!!)
                return true
            }

        })
    }

    override fun clickedItem(characterDto: ResultCharacterDto) {
logd("clicked ")
    }

}