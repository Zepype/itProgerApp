package com.example.itprogerapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import java.lang.Double

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logoRes = findViewById<TextView>(R.id.calculator)
        val firstNum = findViewById<EditText>(R.id.hint_text_first)
        val secondNum = findViewById<EditText>(R.id.hint_text_second)

        val calculateButton = findViewById<Button>(R.id.button_calculate).setOnClickListener {
            val numFirst = firstNum.text.toString().toFloat()
            val numSec = secondNum.text.toString().toFloat()
            val res = numFirst + numSec
            logoRes.text = res.toString()
            val toast = Toast.makeText(this, "You did your operation", Toast.LENGTH_LONG).show()
            // alertDialog()
        }

        val nextPageButton = findViewById<Button>(R.id.button_next_page).setOnClickListener { showNextPage() }

        val fragFirstButton = findViewById<Button>(R.id.fragment_first_button)
        val fragSecButton = findViewById<Button>(R.id.fragment_second_button)
        val frameLayout = findViewById<FrameLayout>(R.id.frame_layout)



        fragFirstButton.setOnClickListener {
            val firstFragment = FirstFragment()
            setNewFragment(firstFragment)
        }

        fragSecButton.setOnClickListener {
            val secondFragment = SecondFragment()
            setNewFragment(secondFragment)
        }

    }

    private fun alertDialog(text:String = "Ну ты программист, конечно"){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("OK") {
                    dialog, _ -> dialog.cancel()
                }
                .setNegativeButton("No (Say goodbye to your app) ") {
                        _, _ -> finish()
                }
        val dialog = builder.create()
                            .show()
    }

    private fun showNextPage() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)

    }

    private fun setNewFragment(fragment: Fragment) {


        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame_layout, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }
}



