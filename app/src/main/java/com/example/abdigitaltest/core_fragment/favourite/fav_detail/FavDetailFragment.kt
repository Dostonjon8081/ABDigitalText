package com.example.abdigitaltest.core_fragment.favourite.fav_detail

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.navigation.fragment.navArgs
import com.example.abdigitaltest.base.BaseFragment
import com.example.abdigitaltest.core_fragment.home.CharactersRvModel
import com.example.abdigitaltest.databinding.FragmentCharacterDetailBinding
import com.example.abdigitaltest.databinding.FragmentFavDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavDetailFragment :
    BaseFragment<FragmentFavDetailBinding>(FragmentFavDetailBinding::inflate) {

    private val args: FavDetailFragmentArgs by navArgs()
    private lateinit var model: CharactersRvModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                getBaseActivity {
                    it.navController?.popBackStack()
                }
            }
        })
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (args.detailArg != null) {
            model = args.detailArg!!
            with(binding) {
                name.text = "name: ${model.name}"
                height.text = "height: ${model.height}"
                mass.text = "mass: ${model.mass}"
                hairColor.text = "hairColor: ${model.hair_color}"
                skinColor.text = "skinColor: ${model.skin_color}"
                eyeColor.text = "eyeColor: ${model.eye_color}"
                birthYear.text = "birthYear: ${model.birth_year}"
                gender.text = "gender: ${model.gender}"
                homeWorld.text = "homeworld: ${model.homeworld}"
                films.text = "films: ${model.films}"
                species.text = "species: ${model.species}"
                vehicles.text = "vehicles: ${model.vehicles}"
                startShip.text = "starships: ${model.starships}"
                created.text = "created: ${model.created}"
                edited.text = "edited: ${model.edited}"
                url.text = "edited: ${model.url}"
            }
        }

    }
}