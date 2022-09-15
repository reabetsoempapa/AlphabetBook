package com.example.alphabetbook

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import com.example.alphabetbook.model.AlphabetGridViewModal

class MainActivity : AppCompatActivity() {

    // on below line we are creating
    // variables for grid view and course list
    private lateinit var alphabetGV: GridView
    private lateinit var alphabetList: List<AlphabetGridViewModal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove Default Action Bar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        alphabetGV = findViewById(R.id.overview_gridview)
        alphabetList = ArrayList()

        var startChar = 'A'
        val endChar = 'Z'

        while (startChar <= endChar) {

            val str : String = startChar.toString()
            val lower : String = str.lowercase()
            val id = resources.getIdentifier(lower, "drawable", this.packageName)
            (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal(startChar.toString(), id))
            startChar++

        }

        val adapter = AlphabetGVController(alphabetList, this@MainActivity)
        alphabetGV.adapter = adapter

        alphabetGV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val bundle = Bundle()
            val letter : String = alphabetList[position].alphabetName

            bundle.putSerializable("object", alphabetList[position])
            bundle.putString("letter", letter)
            bundle.putSerializable("list", alphabetList as  ArrayList<AlphabetGridViewModal>)
            bundle.putInt("intPos", position)

            val intent = Intent(this, AlphabetScreenActivity::class.java)

            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}