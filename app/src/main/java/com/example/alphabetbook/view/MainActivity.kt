package com.example.alphabetbook.view

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.alphabetbook.R
import com.example.alphabetbook.model.AlphabetGridViewModal
import com.example.alphabetbook.presenter.AlphabetGVController
import com.example.alphabetbook.presenter.MainAdapter
import java.io.Serializable

class MainActivity : AppCompatActivity(), Serializable {

    // on below line we are creating
    // variables for grid view and course list
    private lateinit var alphabetGV: GridView
    private var alphabetList: List<AlphabetGridViewModal> = ArrayList()
    private var time = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alphabetGV = findViewById(R.id.overview_gridview)
        val mainAdapter : MainAdapter = MainAdapter( this, alphabetGV )

        // Remove Default Action Bar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        alphabetList = mainAdapter.getGridViewItems()

        val adapter = AlphabetGVController(alphabetList, this@MainActivity)
        alphabetGV.adapter = adapter

        alphabetGV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->

            val bundle = Bundle()
            bundle.putInt("intPos", position)
            bundle.putIntegerArrayList("images", mainAdapter.getImages() )
            val intent = Intent(this, AlphabetScreenActivity::class.java)

            intent.putExtras(bundle)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        if ( time + 2500 > System.currentTimeMillis() ) {
            super.onBackPressed()
        }
        else {
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
        }
        time = System.currentTimeMillis()
    }
}