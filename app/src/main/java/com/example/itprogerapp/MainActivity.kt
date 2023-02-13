package com.example.itprogerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.lang.Double

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logoRes = findViewById<TextView>(R.id.calculator)
        val firstNum = findViewById<EditText>(R.id.hint_text_first)
        val secondNum = findViewById<EditText>(R.id.hint_text_second)
        val calculateButton = findViewById<Button>(R.id.button_calculate)

        calculateButton.setOnClickListener {
            val numFirst = firstNum.text.toString().toFloat()
            val numSec = secondNum.text.toString().toFloat()
            val res = numFirst + numSec
            logoRes.text = res.toString()
            val toast = Toast.makeText(this, "You did your operation", Toast.LENGTH_LONG).show()
            alertDialog()
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

}



