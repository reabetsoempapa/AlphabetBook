package com.example.alphabetbook.model

import android.R
import android.content.Context
import android.graphics.drawable.BitmapDrawable
import androidx.core.content.res.ResourcesCompat
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


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

        // Create a coroutine to load the images without blocking the main thread
        runBlocking {
            val job = launch {
                var startChar = 'A'
                val endChar = 'Z'

                while (startChar <= endChar) {

                    val str : String = startChar.toString()
                    val lower : String = str.lowercase()
                    val id = context.resources.getIdentifier(lower, "drawable", context.packageName)
                    images.add(id)
                    startChar++

                }

                doneLoading = true
            }
        }

    }

    fun getImages() : ArrayList<Int> {
        return images
    }

}