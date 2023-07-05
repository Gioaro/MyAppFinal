package com.example.myappfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class UpdatePasswordActivity : AppCompatActivity() {

    private lateinit var currentPasswordET : TextView
    private lateinit var newPasswordET : TextView
    private lateinit var confirmPasswordET : TextView
    private lateinit var updatePasswordBtn : Button

    private val auth = FirebaseAuth.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_password)
        init()
        listeners()
    }


    private fun listeners() {
        updatePasswordBtn.setOnClickListener {
            val currentPassword = currentPasswordET.text.toString()
            val newPassword = newPasswordET.text.toString()
            val confirmPassword = confirmPasswordET.text.toString()

            if (currentPassword.isEmpty() || newPassword.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Fill in all fields please", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (newPassword != confirmPassword) {
                Toast.makeText(this, "Rewrite password correctly please", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.confirmPasswordReset(currentPassword, newPassword).addOnCompleteListener {task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Registered!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java ))
                    finish()

                } else {
                    Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                }

            }
        }
    }


    private fun init(){
        currentPasswordET = findViewById(R.id.currentPasswordET)
        newPasswordET = findViewById(R.id.newPasswordET)
        confirmPasswordET = findViewById(R.id.confirmPasswordET)
        updatePasswordBtn = findViewById(R.id.updatePasswordBtn)
    }



}