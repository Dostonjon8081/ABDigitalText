package com.example.abdigitaltest.core_fragment.favourite

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.abdigitaltest.MainFragmentDirections
import com.example.abdigitaltest.base.BaseFragment
import com.example.abdigitaltest.core_fragment.home.CharactersRvModel
import com.example.abdigitaltest.databinding.FragmentFavouriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment :
    BaseFragment<FragmentFavouriteBinding>(FragmentFavouriteBinding::inflate), IClickFavItem {
    private val favViewModel: FavViewModel by viewModels()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) { FavAdapter() }

    override fun onResume() {
        super.onResume()
        favViewModel.getCharacters()
        favViewModel.loading.observe(viewLifecycleOwner) {
            binding.favPb.isVisible = it
        }
        favViewModel.getCharacters.observe(viewLifecycleOwner) {
            adapter.initData(it)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.favRv.adapter = adapter

        adapter.initClick(this)
    }

    override fun clickedItem(model: CharactersRvModel) {
        getBaseActivity {
            it.navController?.navigate(
                MainFragmentDirections.actionMainFragmentToFavDetailFragment(model)
            )
        }
    }

    override fun deleteFav(name: String) {
        favViewModel.deleteFav(name)
    }

}