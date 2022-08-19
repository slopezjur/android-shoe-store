package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    // In this case I chose the ConstraintLayout. The LinearLayout could result a simpler way of adding Views
    // but I normally like to have more control and be able to put restrictions between views
    private lateinit var binding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)

        binding.instructionNextButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_instructionFragment_to_shoeListFragment)
        )

        return binding.root
    }
}