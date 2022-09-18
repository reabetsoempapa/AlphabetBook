package com.example.alphabetbook.view

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.alphabetbook.R
import com.example.alphabetbook.presenter.AlphabetPresenter
import com.example.alphabetbook.presenter.MainAdapter

class AlphabetScreenActivity : AppCompatActivity() {

    // Buttons
    private lateinit var nextButton : Button
    private lateinit var prevButton : Button
    private lateinit var firstButton : Button
    private lateinit var lastButton : Button
    private lateinit var overviewButton : Button

    // Views
    private lateinit var imageView : ImageView

    // Instance Variables
    private var integerPos = 0
    private var startPos = 0
    private var endPos = 0
    private var skippedToLast = false
    private lateinit var presenter : AlphabetPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_screen)
        // View
        imageView = findViewById<ImageView>(R.id.image_view)

        // instantiate buttons
        nextButton = findViewById<Button>(R.id.next_activity_button)
        prevButton = findViewById<Button>(R.id.previous_activity_button)
        firstButton = findViewById<Button>(R.id.first_activity_button)
        lastButton = findViewById<Button>(R.id.last_activity_button)
        overviewButton = findViewById<Button>(R.id.overview_button)

        // Set the Alphabet presenter for this
        presenter = AlphabetPresenter( imageView , this )

        presenter.setButtons( nextButton, prevButton, firstButton, lastButton, overviewButton )

        val bundle = intent.extras

        integerPos = bundle?.getInt("intPos")!!
        startPos = integerPos
        endPos = integerPos
        val images : ArrayList<Int> = bundle!!.getIntegerArrayList("images") as ArrayList<Int>
        presenter.setImageRepository(images)

        presenter.onGridItemClick( integerPos as Int )

        prevButton.setOnClickListener {
            presenter.onClickPrevious(false)
            endPos--
        }

        nextButton.setOnClickListener {
            presenter.onClickNext()
            endPos++
        }

        firstButton.setOnClickListener {
            presenter.onClickFirst()
            endPos = 0
        }

        lastButton.setOnClickListener {
            presenter.onClickLast()
            skippedToLast = true
        }

        overviewButton.setOnClickListener {
            startPos = 0
            endPos = 0
            integerPos = 0
            presenter.onClickOverView()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onBackPressed() {

        if ( ( endPos == 0 ) || ( startPos >= endPos )) {
            super.onBackPressed()
        }
        else if ( skippedToLast ) {
            presenter.onClickPrevious(true)
        }
        else {
            presenter.onClickPrevious(true)
            endPos--
        }

    }

}