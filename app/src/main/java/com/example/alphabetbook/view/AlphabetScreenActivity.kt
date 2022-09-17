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
        val presenter : AlphabetPresenter = AlphabetPresenter( imageView , this )

        presenter.setButtons( nextButton, prevButton, firstButton, lastButton, overviewButton )

        val bundle = intent.extras

        val integerPos = bundle?.getInt("intPos")
        val images : ArrayList<Int> = bundle!!.getIntegerArrayList("images") as ArrayList<Int>
        presenter.setImageRepository(images)

        presenter.onGridItemClick( integerPos as Int )

        prevButton.setOnClickListener {
            presenter.onClickPrevious(integerPos as Int)
        }

        nextButton.setOnClickListener {
            presenter.onClickNext(integerPos as Int)
        }

        firstButton.setOnClickListener {
            presenter.onClickFirst(integerPos as Int)
        }

        lastButton.setOnClickListener {
            presenter.onClickLast(integerPos as Int)
        }

        overviewButton.setOnClickListener {
            presenter.onClickOverView()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

}