package com.dicoding.kostracker

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var rvKost: RecyclerView
    private val list = ArrayList<Kost>()

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        rvKost = findViewById(R.id.rv_kost)
        rvKost.setHasFixedSize(true)

        list.addAll(getListKost())


        rvKost.layoutManager = LinearLayoutManager(this)
        rvKost.adapter = ListKostAdapter(list) { clickedItem ->
            val intent = Intent(this, DetailKostActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, clickedItem)
            startActivity(intent)
        }

        val btnMoveActivity: FloatingActionButton = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener {
            val intent = Intent(this, MoveActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getListKost(): ArrayList<Kost>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataFacility = resources.getStringArray(R.array.data_facility)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataAddress = resources.getStringArray(R.array.data_address)

        val listKost = ArrayList<Kost>()
        for (i in dataName.indices){
            val kost = Kost(dataName[i], dataFacility[i], dataPhoto.getResourceId(i, -1), dataPrice[i], dataAddress[i])
            listKost.add(kost)
        }
        return listKost
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvKost.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_grid -> {
                rvKost.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }



}