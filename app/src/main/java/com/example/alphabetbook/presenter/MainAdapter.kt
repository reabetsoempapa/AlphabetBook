package com.example.alphabetbook.presenter

import android.content.Context
import android.graphics.Bitmap
import android.widget.GridView
import com.example.alphabetbook.R
import com.example.alphabetbook.model.AlphabetGridViewModal
import com.example.alphabetbook.model.ImageRepository
import java.io.Serializable

class MainAdapter ( context: Context, gridView : GridView ) {

    private var imageRepo : ImageRepository
    private var alphabetGV: GridView
    private var alphabetList: List<AlphabetGridViewModal>
    private val context : Context

    init {
        this.context = context
        imageRepo = ImageRepository( context )
        alphabetGV = gridView
        alphabetList = ArrayList()
        setupGridView()
        imageRepo.loadImages()
    }

    fun getImages() : ArrayList<Int> {
        return imageRepo.getImages()
    }

    fun getGridViewItems() : ArrayList<AlphabetGridViewModal> {
        return alphabetList as ArrayList<AlphabetGridViewModal>
    }

    private fun setupGridView() {

        var startChar = 'A'
        val endChar = 'Z'

        while (startChar <= endChar) {

            val str : String = startChar.toString()
            val lower : String = str.lowercase()
            val id = context.resources.getIdentifier(lower, "drawable", context.packageName)
            (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal(startChar.toString(), id))
            startChar++
        }
    }
}