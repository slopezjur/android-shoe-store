package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    // In this case I chose the ConstraintLayout. The LinearLayout could result a simpler way of adding Views
    // but I normally like to have more control and be able to put restrictions between views
    private lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_welcome, container, false)

        binding.welcomeNextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_welcomeFragment_to_instructionFragment)
        )

        return binding.root
    }
}