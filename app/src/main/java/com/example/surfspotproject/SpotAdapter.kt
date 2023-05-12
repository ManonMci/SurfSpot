package com.example.surfspotproject

import android.content.Context
import android.widget.ArrayAdapter
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView


class SpotAdapter(context: Context, spots: List<Spot>) : ArrayAdapter<Spot>(context, 0, spots) {
    private val spotsList: List<Spot> = spots

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var listItemView = convertView
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item_spot, parent, false)
        }

        val currentSpot = spotsList[position]

        val spotImage = listItemView!!.findViewById<ImageView>(R.id.spot_image)
        currentSpot.image?.let { spotImage.setImageResource(it) }

        val spotName = listItemView.findViewById<TextView>(R.id.spot_name)
        spotName.text = currentSpot.name

        val spotLocation = listItemView.findViewById<TextView>(R.id.spot_location)
        spotLocation.text = currentSpot.location

        return listItemView
    }
}

