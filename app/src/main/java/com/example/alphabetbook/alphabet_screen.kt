package com.example.alphabetbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alphabetbook.model.AlphabetGridViewModal

class alphabet_screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet_screen)
        val alphabet = intent.getSerializableExtra("object")as AlphabetGridViewModal
    }
}