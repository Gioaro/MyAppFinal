package com.example.myappfinal

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth


class SettingsActivity : AppCompatActivity() {


    private lateinit var iconHome : ImageView
    private lateinit var iconSearch : ImageView
    private lateinit var iconSettings : ImageView
    private lateinit var iconProfile : ImageView
    private lateinit var logoutBtn : Button
    private lateinit var deleteBtn : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        init()
        listeners()
    }




    private fun listeners() {

        deleteBtn.setOnClickListener {

            val user = FirebaseAuth.getInstance().currentUser

            val credential = EmailAuthProvider
                .getCredential("user@example.com", "password1234")


            user!!.reauthenticate(credential)
                .addOnCompleteListener {
                    user!!.delete()
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d(TAG, "User account deleted.")
                            }
                        }
                }


        }

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


        logoutBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }


    }



    private fun init() {
        iconHome = findViewById(R.id.iconHome)
        iconSearch = findViewById(R.id.iconSearch)
        iconSettings = findViewById(R.id.iconSettings)
        iconProfile = findViewById(R.id.iconProfile)
        logoutBtn = findViewById(R.id.logoutBtn)
        deleteBtn = findViewById(R.id.deleteBtn)

    }





}