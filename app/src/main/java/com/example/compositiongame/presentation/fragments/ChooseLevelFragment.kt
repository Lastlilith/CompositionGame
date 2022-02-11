package com.example.compositiongame.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.compositiongame.databinding.FragmentChooseLevelBinding
import com.example.compositiongame.domain.entities.Level
import com.example.compositiongame.utils.doubleVibrateButton
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

class ChooseLevelFragment : Fragment() {

    private var _binding: FragmentChooseLevelBinding? = null
    private val binding: FragmentChooseLevelBinding
        get() = _binding ?: throw RuntimeException("FragmentChooseLevelBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChooseLevelBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            buttonLevelEasy.setOnClickListener {
                doubleVibrateButton()
                launchGameFragment(Level.EASY)
            }
            buttonLevelNormal.setOnClickListener {
                doubleVibrateButton()
                launchGameFragment(Level.MEDIUM)
            }
            buttonLevelHard.setOnClickListener {
                doubleVibrateButton()
                launchGameFragment(Level.HARD)
            }
        }
        //Google ads
        MobileAds.initialize(requireContext())
        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)
    }

    private fun launchGameFragment(level: Level) {
        findNavController().navigate(
            ChooseLevelFragmentDirections.actionChooseLevelFragmentToGameFragment(
                level
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}