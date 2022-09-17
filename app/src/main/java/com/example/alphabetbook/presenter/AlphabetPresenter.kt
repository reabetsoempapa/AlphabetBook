package com.example.alphabetbook.presenter

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import com.example.alphabetbook.model.ImageRepository

class AlphabetPresenter ( imageView : ImageView , context : Context){

    private var imageRepo : ImageRepository
    private var imageView : ImageView

    private lateinit var nextButton : Button
    private lateinit var prevButton : Button
    private lateinit var firstButton : Button
    private lateinit var lastButton : Button
    private lateinit var overViewButton : Button

    init {
        imageRepo = ImageRepository( context )
        this.imageView = imageView
    }

    public fun setButtons( nextButton : Button , prevButton : Button ,
                           firstButton : Button , lastButton : Button , overViewButton: Button) {

        this.nextButton = nextButton
        this.prevButton = prevButton
        this.firstButton = firstButton
        this.lastButton = lastButton

    }

    public fun onClickNext( position : Int ) {

    }

    public fun onClickPrevious( imageView : ImageView) {

    }

    public fun onClickFirst( imageView : ImageView) {

    }

    public fun onClickLast( imageView : ImageView) {

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