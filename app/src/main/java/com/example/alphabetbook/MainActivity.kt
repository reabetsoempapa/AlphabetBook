package com.example.alphabetbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.GridView
import android.widget.Toast
import com.example.alphabetbook.model.AlphabetGridViewModal

class MainActivity : AppCompatActivity() {

    // on below line we are creating
    // variables for grid view and course list
    lateinit var alphabetGV: GridView
    lateinit var alphabetList: List<AlphabetGridViewModal>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Remove Action Bar
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        alphabetGV = findViewById(R.id.overview_gridview)
        alphabetList = ArrayList<AlphabetGridViewModal>()

        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("A", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("B", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("C", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("D", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("E", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("F", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("G", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("H", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("I", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("J", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("K", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("L", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("M", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("N", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("O", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("P", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("Q", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("R", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("S", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("T", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("U", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("V", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("W", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("X", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("Y", R.drawable.ic_insert_photo) )
        (alphabetList as ArrayList<AlphabetGridViewModal>).add(AlphabetGridViewModal("Z", R.drawable.ic_insert_photo) )


        // on below line we are setting adapter to our grid view
        val Adapter = AlphabetGVController(alphabetList, this@MainActivity)

        alphabetGV.setAdapter(Adapter)
        // on below line we are adding on item
        // click listener for our grid view.
        alphabetGV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            // inside on click method we are simply displaying
            // a toast message with course name.
            var intent = Intent(this, alphabet_screen::class.java)
            intent.putExtra("object",alphabetList[position])

            startActivity(intent)
            Toast.makeText(
                applicationContext, alphabetList[position].alphabetName + " selected",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}