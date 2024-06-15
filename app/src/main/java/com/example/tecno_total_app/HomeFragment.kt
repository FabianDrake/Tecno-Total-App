package com.example.tecno_total_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val welcomeText: TextView = view.findViewById(R.id.welcome_text)
        val offerImage: ImageView = view.findViewById(R.id.offer_image)

        // Set the welcome text
        welcomeText.text = "¡Bienvenidos a nuestra app!"

        // Set the offer image
        // Make sure to replace R.drawable.offer_image with your actual offer image
        offerImage.setImageResource(R.drawable.offer_image)

        return view
    }
}