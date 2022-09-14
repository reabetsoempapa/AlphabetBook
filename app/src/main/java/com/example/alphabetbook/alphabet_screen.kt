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

        //val alphabet = intent.getSerializableExtra("object")as AlphabetGridViewModal

        //val lists = intent.getSerializableExtra("lists")
        val bundle = intent.extras
        val lists = bundle!!.getSerializable("object")
        val alphabet = bundle!!.getSerializable("list")

        val  aButtonClicked = findViewById<Button>(R.id.a_button) as Button
        val nextButtonClicked = findViewById<Button>(R.id.next_button) as Button

        aButtonClicked.setOnClickListener {

           var intent = Intent(this, MainActivity::class.java)


           // intent.

           // startActivity(intent)
        }
        nextButtonClicked.setOnClickListener {

        }




    }
}