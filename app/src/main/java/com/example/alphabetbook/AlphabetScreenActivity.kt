package com.example.alphabetbook

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.alphabetbook.model.AlphabetGridViewModal

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

        val bundle = intent.extras
        val lists = bundle!!.getSerializable("object") as AlphabetGridViewModal

        val id = resources.getIdentifier(lists.alphabetName.lowercase(),"drawable",packageName)
        imageView.setImageResource(id)

        val alphabets = bundle.getSerializable("list") as ArrayList<AlphabetGridViewModal>
        var integerPos = bundle.getInt("intPos")
        loadButtons(integerPos)

        prevButton.setOnClickListener {
            integerPos--
            imageView.setImageResource(alphabets[integerPos].alphabetImage)
            loadButtons(integerPos)
        }

        nextButton.setOnClickListener {
            integerPos++
            imageView.setImageResource(alphabets[integerPos].alphabetImage)
            loadButtons(integerPos)
        }

        firstButton.setOnClickListener {
            integerPos = 0
            imageView.setImageResource(alphabets[integerPos].alphabetImage)
            loadButtons(integerPos)
        }

        lastButton.setOnClickListener {
            integerPos = 25
            imageView.setImageResource(alphabets[integerPos].alphabetImage)
            loadButtons(integerPos)
        }

        overviewButton.setOnClickListener {
            integerPos = 0
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

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