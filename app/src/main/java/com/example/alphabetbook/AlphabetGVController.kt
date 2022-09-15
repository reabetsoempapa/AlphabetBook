package com.example.alphabetbook

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.alphabetbook.model.AlphabetGridViewModal

internal class AlphabetGVController(
    // A list of all the alphabet items in the overview activity
    private val alphabetList: List<AlphabetGridViewModal>,
    private val context: Context

) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var alphabetTV: TextView
    //private lateinit var alphabetIV: ImageView

    override fun getCount(): Int {
        return alphabetList.size
    }

    override fun getItem(position: Int): Any {
        return alphabetList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView
        // on blow line we are checking if layout inflater
        // is null, if it is null we are initializing it.
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        // on the below line we are checking if convert view is null.
        // If it is null we are initializing it.
        if (convertView == null) {
            // on below line we are passing the layout file
            // which we have to inflate for each item of grid view.
            convertView = layoutInflater!!.inflate(R.layout.alphabet_gridview_item, null)
        }

        // on below line we are initializing our alphabet image view
        // and alphabet text view with their ids.
        //alphabetIV = convertView!!.findViewById(R.id.alphabetGV_imageView)
        alphabetTV = convertView!!.findViewById(R.id.alphabetGV_textView)
        // on below line we are setting image for our alphabet image view.
        //alphabetIV.setImageResource(alphabetList.get(position).alphabetImage)
        // on below line we are setting text in our alphabet text view.
        alphabetTV.setText(alphabetList.get(position).alphabetName)
        // at last we are returning our convert view.
        return convertView
    }


}