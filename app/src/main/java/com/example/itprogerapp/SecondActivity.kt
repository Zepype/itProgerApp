package com.example.itprogerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        val goBackPage = findViewById<Button>(R.id.go_back_button).setOnClickListener { goBackPage() }
    }

    private fun goBackPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}