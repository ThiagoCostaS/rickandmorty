package com.example.rickandmortyapi.ui.listcharacters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentCharacterBinding
import com.example.rickandmortyapi.domain.model.CharacterDomain
import com.example.rickandmortyapi.domain.model.ResultDomain
import com.example.rickandmortyapi.ui.listcharacters.adapter.ListCharacterAdapter
import com.example.rickandmortyapi.ui.listcharacters.viewmodel.CharacterViewAction
import com.example.rickandmortyapi.ui.listcharacters.viewmodel.CharacterViewModel
import com.example.rickandmortyapi.ui.listcharacters.viewmodel.CharacterViewState
import com.example.rickandmortyapi.utils.OnLastItemsScrollListener
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment : Fragment() {

    private val viewModel: CharacterViewModel by viewModel()
    private lateinit var binding: FragmentCharacterBinding
    private lateinit var adapterList: ListCharacterAdapter

    private val onLastItemsScrollListener = OnLastItemsScrollListener {
        viewModel.dispatchAction(CharacterViewAction.NextCharactersList)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dispatchAction()
        configObserver()
    }


    private fun configObserver() {
        lifecycleScope.launch {
            viewModel.viewState.observe(viewLifecycleOwner) { viewState ->
                when (viewState) {
                    CharacterViewState.Error -> goToScreenError()
                    CharacterViewState.Loading -> showLoading(isLoading = true)
                    is CharacterViewState.ShowCharacters -> {
                        showLoading(isLoading = false)
                        handleListCharacters(viewState.character)

                    }

                    is CharacterViewState.SetNextCharacterPage -> {
                        showLoading(isLoading = false)
                        setNextPageCharacter(viewState.character.results)
                    }

                    null -> Unit
                }
            }
        }
    }

    private fun goToScreenError() {
        findNavController().navigate(R.id.action_characterFragment_to_errorFragment)
    }

    private fun showLoading(isLoading: Boolean = false) {
        if (isLoading) {
            binding.progressBar.visibility = View.VISIBLE
            val rotation = AnimationUtils.loadAnimation(context, R.anim.rotate)
            binding.progressBar.startAnimation(rotation)
        } else {
            binding.progressBar.clearAnimation()
            binding.progressBar.visibility = View.GONE
        }
    }

    private fun setNextPageCharacter(listCharacter: List<ResultDomain>) {
        adapterList.addList(listCharacter)

        onLastItemsScrollListener.setLoaded()
    }

    private fun handleListCharacters(listCharacter: CharacterDomain) {
        adapterList = ListCharacterAdapter{
            val bundle = bundleOf("characterInfo" to it)
            findNavController().navigate(R.id.action_characterFragment_to_characterInfoFragment, bundle)

        }

        binding.rv.apply {
            adapter = adapterList
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapterList.setList(listCharacter.results)
            addOnScrollListener(onLastItemsScrollListener)
        }
    }

    private fun dispatchAction() {
        viewModel.dispatchAction(CharacterViewAction.GetCharacters)
    }
}
