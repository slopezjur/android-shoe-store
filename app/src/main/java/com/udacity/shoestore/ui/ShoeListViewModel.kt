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

        repeat(10) {
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

    fun addShoe(shoe: Shoe, editMode: Boolean) {
        // TODO - Fix. This won't prevent to modify a current list item to remove some of the fields
        // due to the shared activityViewModels
        if (!editMode && shoe.name.isNotEmpty()) {
            val shoeListOld = _shoeList.value?.toMutableList()
            shoeListOld?.add(shoe)
            _shoeList.value = shoeListOld?.toMutableList()
        }
    }
}