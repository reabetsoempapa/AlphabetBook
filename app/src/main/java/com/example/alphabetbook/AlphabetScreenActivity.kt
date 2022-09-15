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

        val  firstPageButton = findViewById<Button>(R.id.first_activity_button) as Button
        val nextPageButton = findViewById<Button>(R.id.next_activity_button) as Button

        firstPageButton.setOnClickListener {

           var intent = Intent(this, MainActivity::class.java)


           // intent.

           // startActivity(intent)
        }
        nextPageButton.setOnClickListener {

        }

    }
}