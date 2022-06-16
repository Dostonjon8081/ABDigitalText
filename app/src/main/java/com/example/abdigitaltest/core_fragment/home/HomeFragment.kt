package com.example.abdigitaltest.core_fragment.home

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.abdigitaltest.MainFragmentDirections
import com.example.abdigitaltest.base.BaseFragment
import com.example.abdigitaltest.databinding.FragmentHomeBinding
import com.example.abdigitaltest.util.dialog.CustomDialog
import com.muddassir.connection_checker.ConnectionState
import com.muddassir.connection_checker.checkConnection
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    IClickCharacterItem {

    private val homeViewModel: HomeViewModel by viewModels()
    private val characterAdapter by lazy(LazyThreadSafetyMode.NONE) { CharacterAdapter() }

    private fun findFragmentByTag(tag: String?): Fragment? =
        requireActivity().supportFragmentManager.findFragmentByTag(tag)

    private lateinit var dialog: CustomDialog

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.charactersRv.adapter = characterAdapter
        checkConnect()
        homeViewModel
        homeViewModel.loading.observe(viewLifecycleOwner) {
            binding.homePb.isVisible = it
        }
        homeViewModel.charactersResponseApi.observe(viewLifecycleOwner) { model ->
            characterAdapter.initDat(model)
        }

        homeViewModel.searchCharacter.observe(viewLifecycleOwner) { model ->
            characterAdapter.initDat(model)
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

    private fun checkConnect() {
        checkConnection(this) {
            showErrorDialog(
                when (it) {
                    ConnectionState.CONNECTED -> {
                        homeViewModel.getCharacters()
                        dialog.dismiss()
                        "Connected"
                    }
                    else -> {
                        "Disconnected!\n Please check your network"
                    }
                }
            )
        }
    }

    override fun clickedItem(model: CharactersRvModel) {
        getBaseActivity {
            it.navController?.navigate(
                MainFragmentDirections.actionMainFragmentToCharacterDetailFragment(
                    model
                )
            )
        }
    }

    override fun addFav(model: CharactersRvModel) {
        homeViewModel.addFav(model)
    }

    override fun deleteFav(model: CharactersRvModel) {
        homeViewModel.deleteFav(model)
    }

    private fun showErrorDialog(message: String) {
        val foundFragment = findFragmentByTag(CustomDialog::class.java.name)
        if (foundFragment != null && foundFragment.isAdded) return


        dialog = CustomDialog.newInstance(
            message,
            true
        )

        dialog.show(requireActivity().supportFragmentManager, CustomDialog::class.java.name)
    }

}