package com.example.alphabetbook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.alphabetbook.model.AlphabetGridViewModal

class alphabet_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_screen)

        //Passing the arraylist to this page

       // lists = i.getStringArrayListExtra("lists")


        val alphabet = intent.getSerializableExtra("object")as AlphabetGridViewModal

        val  aButtonClicked = findViewById<Button>(R.id.a_button) as Button

        aButtonClicked.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)

           // intent.

           // startActivity(intent)
        }




    }
}