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
        val shoeMutableList = mutableListOf<Shoe>()

        repeat(15) {
            shoeMutableList.add(it, generateRandomShoe(it + 1))
        }

        _shoeList.value = shoeMutableList
    }

    private fun generateRandomShoe(number: Int): Shoe {
        return Shoe(
            name = "Shoe$number",
            size = number.toDouble(),
            company = "Company$number",
            description = "Desc$number",
            images = listOf("image1", "image2")
        )
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.toMutableList()?.add(shoe)
    }
}