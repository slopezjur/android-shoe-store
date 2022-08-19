package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    // In this case I chose the ConstraintLayout. The LinearLayout could result a simpler way of adding Views
    // but I normally like to have more control and be able to put restrictions between views
    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: ShoeListViewModel by activityViewModels()

    private var editMode = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        arguments?.let {
            val args = ShoeDetailFragmentArgs.fromBundle(it)
            binding.shoe = args.shoe
            editMode = true
        }

        setupNavigation()

        return binding.root
    }

    private fun setupNavigation() {
        binding.shoeDetailSaveButton.setOnClickListener {
            // TODO - Fix. binding.shoe It is null when we open an empty ShoeDetailFragment to add a new one...
            //binding.shoe?.let { viewModel.addShoe(it) }
            viewModel.addShoe(getShoe(), editMode)

            requireView().findNavController()
                .navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }

        binding.shoeDetailCancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoeDetailFragment_to_shoeListFragment)
        )
    }

    private fun getShoe() =
        Shoe(
            name = binding.shoeDetailNameEt.text.toString(),
            company = binding.shoeDetailCompanyEt.text.toString(),
            size = binding.shoeDetailSizeEt.text.toString().toDouble(),
            description = binding.shoeDetailDescriptionEt.text.toString()
        )
}