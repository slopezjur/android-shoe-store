package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.shoe = Shoe(
            "SafeArgs",
            1.0,
            "SafeArgs",
            "SafeArgs",
            listOf("SafeArgs", "SafeArgs", "SafeArgs")
        )

        setupNavigation()

        return binding.root
    }

    private fun setupNavigation() {
        binding.shoeDetailSaveButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )

        binding.shoeDetailCancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )
    }
}