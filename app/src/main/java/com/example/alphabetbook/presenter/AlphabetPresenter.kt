package com.example.alphabetbook.presenter

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.alphabetbook.model.ImageRepository
import com.example.alphabetbook.view.MainActivity

class AlphabetPresenter ( imageView : ImageView , context : Context){
    
    private var imageView : ImageView
    private var currentIndex : Int
    private lateinit var images : ArrayList<Int>

    private lateinit var nextButton : Button
    private lateinit var prevButton : Button
    private lateinit var firstButton : Button
    private lateinit var lastButton : Button
    private lateinit var overViewButton : Button

    init {
        this.imageView = imageView
        currentIndex = 0
    }

    public fun setButtons( nextButton : Button , prevButton : Button ,
                           firstButton : Button , lastButton : Button , overViewButton: Button) {

        this.nextButton = nextButton
        this.prevButton = prevButton
        this.firstButton = firstButton
        this.lastButton = lastButton
        this.overViewButton = overViewButton

    }

    public fun onClickNext(i: Int) {
        currentIndex++
        setBitMapToImageView( currentIndex )
        loadButtons( currentIndex )

    }

    public fun onClickPrevious( position : Int  ) {
        currentIndex--
        setBitMapToImageView( currentIndex )
        loadButtons( currentIndex )
    }

    public fun onClickFirst( position : Int  ) {
        currentIndex = 0
        setBitMapToImageView( currentIndex )
        loadButtons( currentIndex )
    }

    public fun onClickLast( position : Int  ) {
        currentIndex = 25
        setBitMapToImageView( currentIndex )
        loadButtons( currentIndex )
    }

    public fun onClickOverView() {
        currentIndex = 0
    }

    public fun onGridItemClick ( position : Int ) {
        currentIndex = position
        setBitMapToImageView( position )
        loadButtons( currentIndex )
    }

    private fun setBitMapToImageView(position : Int ) {
        imageView.setImageResource( images[position] )
    }

    fun setImageRepository ( images : ArrayList<Int> ) {
        this.images = images
    }

    private fun loadButtons( position : Int ){

        if ( position == 0) {
            prevButton.visibility = View.INVISIBLE
            firstButton.visibility = View.INVISIBLE
        }
        else {
            prevButton.visibility = View.VISIBLE
            firstButton.visibility = View.VISIBLE
        }

        if( position == 25 ){
            nextButton.visibility = View.INVISIBLE
            lastButton.visibility = View.INVISIBLE
        }
        else{
            nextButton.visibility = View.VISIBLE
            lastButton.visibility = View.VISIBLE
        }
    }
}