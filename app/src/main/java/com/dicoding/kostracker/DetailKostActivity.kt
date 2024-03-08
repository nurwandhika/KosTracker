package com.dicoding.kostracker

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class DetailKostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kost)

        val kost = intent.getParcelableExtra<Kost>(MainActivity.INTENT_PARCELABLE)


        val name = findViewById<TextView>(R.id.tv_item_name)
        val photo = findViewById<ImageView>(R.id.img_item_photo)
        val facility = findViewById<TextView>(R.id.tv_item_facility)
        val price = findViewById<TextView>(R.id.tv_item_price)
        val tvItemAddress: TextView = findViewById(R.id.tv_item_address)
        tvItemAddress.text = kost?.address

        photo.setImageResource(kost?.photo!!)
        name.text = kost.name
        facility.text = kost.facility
        price.text = kost.price
    }
}