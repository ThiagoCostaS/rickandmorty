package com.example.rickandmortyapi.ui.charactersdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterInfoBinding
import com.example.rickandmortyapi.domain.model.CharacterDomain
import com.example.rickandmortyapi.domain.model.ResultDomain
import com.example.rickandmortyapi.extensions.loadImageWithShimmer

class CharacterInfoFragment : Fragment() {

    private lateinit var binding: FragmentCharacterInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val character = arguments?.getParcelable<ResultDomain>("characterInfo")
        binding = FragmentCharacterInfoBinding.inflate(inflater, container, false)
        configureToolbar()
        character?.let {
            handleCharacterInfo(it)
        }

        return binding.root
    }

    private fun configureToolbar(){
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_characterInfoFragment_to_characterFragment)
        }
    }

    private fun handleCharacterInfo(character: ResultDomain){
        with(binding){
            this.imageViewCharacter.loadImageWithShimmer(character.image, shimmer)
            this.textNameTitle.text = character.name
            this.textViewGender.text = "Sexo:  ${character.gender}"
            this.textViewSpecies.text = "Espécie:  ${character.species}"
            this.textViewStatus.text = "Status:  ${character.status}"

        }
    }
}