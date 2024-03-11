package com.example.rickandmortyapi.ui.error

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rickandmortyapi.R
import com.example.rickandmortyapi.databinding.FragmentErrorBinding

class ErrorFragment : Fragment() {

    private lateinit var binding: FragmentErrorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentErrorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBackPressed()
    }

    private fun onBackPressed() {
        binding.backButton.setOnClickListener {
            findNavController().navigate(R.id.action_errorFragment_to_characterFragment)
        }
    }
}