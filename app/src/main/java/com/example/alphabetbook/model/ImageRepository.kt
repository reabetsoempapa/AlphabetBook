package com.example.alphabetbook.model

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.Serializable

class ImageRepository ( context : Context) {

    private var context: Context

    init  {
        this.context = context
        images = ArrayList()
    }

    companion object {
        private var images : ArrayList<Int> = ArrayList()
        private var doneLoading = false

        fun getImageBitMap( position : Int ) : Int {
            println( "Array size : ${images.size}")
            return images[position]
        }
    }

    fun loadImages(){

        var startChar = 'A'
        val endChar = 'Z'

        while (startChar <= endChar) {

            val str : String = startChar.toString()
            val lower : String = str.lowercase()
            val id = context.resources.getIdentifier(lower, "drawable", context.packageName)
            images.add(id)
            startChar++
            println( "Array size : ${images.size}")
            println("The bitmap with id : $id for $lower has been created")
        }

        doneLoading = true

    }

    fun getImages() : ArrayList<Int> {
        return images
    }

}