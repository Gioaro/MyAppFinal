package com.example.myappfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class SearchActivity : AppCompatActivity() {

    private lateinit var iconHome : ImageView
    private lateinit var iconSearch : ImageView
    private lateinit var iconSettings : ImageView
    private lateinit var iconProfile : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        init()
        listeners()
    }


    private fun listeners() {

        iconHome.setOnClickListener {
            startActivity(Intent(this, FeedActivity::class.java))
        }


        iconSearch.setOnClickListener {
            startActivity(Intent(this, SearchActivity::class.java))
        }

        iconSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }


        iconProfile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }


    }




    private fun init() {
        iconHome = findViewById(R.id.iconHome)
        iconSearch = findViewById(R.id.iconSearch)
        iconSettings = findViewById(R.id.iconSettings)
        iconProfile = findViewById(R.id.iconProfile)
    }


}