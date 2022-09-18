package com.example.alphabetbook.presenter

import android.R
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.view.View
import android.widget.Button
import android.widget.ImageView
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class AlphabetPresenter ( imageView : ImageView , context : Context){
    
    private var imageView : ImageView
    private var currentIndex : Int
    private var startPos = 0
    private var endPos = 0
    private var skippedToLast = false
    private var doneLoading = false
    private lateinit var images : ArrayList<Int>
    private lateinit var bitImages : ArrayList<Bitmap>

    // activity context
    private lateinit var context : Context

    // Buttons
    private lateinit var nextButton : Button
    private lateinit var prevButton : Button
    private lateinit var firstButton : Button
    private lateinit var lastButton : Button
    private lateinit var overViewButton : Button

    init {
        this.context = context
        this.imageView = imageView
        currentIndex = 0
        bitImages = ArrayList<Bitmap>()

    }

    fun setButtons( nextButton : Button , prevButton : Button , firstButton : Button , lastButton : Button , overViewButton: Button) {

        this.nextButton = nextButton
        this.prevButton = prevButton
        this.firstButton = firstButton
        this.lastButton = lastButton
        this.overViewButton = overViewButton

    }

    fun onClickNext() {
        currentIndex++
        endPos++
        setBitMapToImageView( endPos )
        loadButtons( endPos )

    }

    fun onClickPrevious( backPressed : Boolean ) {


        if ( skippedToLast ) {
            skippedToLast = false
            if ( backPressed ) {
                currentIndex = endPos
                setBitMapToImageView( endPos )
                loadButtons( endPos )
            }
            else {
                currentIndex--
                endPos--
                startPos = currentIndex
                setBitMapToImageView( currentIndex )
                loadButtons( currentIndex )
            }

        }
        else {
            currentIndex--
            endPos--
            setBitMapToImageView( currentIndex )
            loadButtons( currentIndex )
        }

    }

    fun onClickFirst() {
        currentIndex = 0
        startPos = 0
        endPos = 0
        skippedToLast = false
        setBitMapToImageView( currentIndex )
        loadButtons( currentIndex )
    }

    fun onClickLast() {
        currentIndex = 25
        skippedToLast = true
        setBitMapToImageView( currentIndex )
        loadButtons( currentIndex )
    }

    fun onClickOverView() {
        currentIndex = 0
        startPos = 0
        endPos = 0
        skippedToLast = false
    }

    fun onGridItemClick ( position : Int ) {
        currentIndex = position
        startPos = position
        endPos = position
        setBitMapToImageView( position )
        loadButtons( currentIndex )
    }

    private fun setBitMapToImageView(position : Int ) {
        setImageBitMapToImageView(position)
        // imageView.setImageResource( images[position] )
    }

    private fun setImageBitMapToImageView( position : Int ) {
        runBlocking {
            val job = launch {
                val options = BitmapFactory.Options()
                options.inJustDecodeBounds = true

                val image : Bitmap = BitmapFactory.decodeResource( context.getResources(), images[position] )
                imageView.setImageBitmap(image)

            }
        }
    }

    private fun loadImageBitMaps() {

        runBlocking {
            for ( id : Int in images ) {
                val image : Bitmap = BitmapFactory.decodeResource( context.getResources(), id )
                bitImages.add(image)
                println("Done Loading A mf")
            }
            println("Done Loading mf")
            doneLoading = true
        }
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