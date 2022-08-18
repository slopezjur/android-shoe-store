package com.udacity.shoestore.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe

class ShoeItemView : ConstraintLayout {

    // TODO : Fix
    //private lateinit var binding: ShoeItemViewBinding

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init()
    }

    private fun init() {
        // TODO : Fix
        //binding = ShoeItemViewBinding.inflate(LayoutInflater.from(context))
        inflate(context, R.layout.shoe_item_view, this)
    }

    fun setupShoe(shoe: Shoe) {
        // TODO : Fix
        //binding.shoeItemName.text = shoe.name

        val shoeItemName: TextView = findViewById(R.id.shoe_item_name_size)
        val text = context.getString(
            R.string.shoe_item_name_size_text,
            shoe.name,
            shoe.size.toString()
        )
        shoeItemName.text = text
    }
}