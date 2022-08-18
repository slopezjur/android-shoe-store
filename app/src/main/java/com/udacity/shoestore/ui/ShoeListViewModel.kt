package com.udacity.shoestore.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeListViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>>
        get() = _shoeList

    init {
        populateShoeList()
    }

    private fun populateShoeList() {
        _shoeList.value = mutableListOf(
            Shoe(
                name = "Shoe1",
                size = 1.0,
                company = "Company1",
                description = "Desc1",
                images = listOf("image1", "image2")
            ),
            Shoe(
                name = "Shoe2",
                size = 2.0,
                company = "Company2",
                description = "Desc2",
                images = listOf("image1", "image2")
            ),
            Shoe(
                name = "Shoe3",
                size = 3.0,
                company = "Company3",
                description = "Desc3",
                images = listOf("image1", "image2")
            ),
            Shoe(
                name = "Shoe4",
                size = 4.0,
                company = "Company4",
                description = "Desc4",
                images = listOf("image1", "image2")
            )
        )
    }
}