package com.example.itprogerapp

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        
        val goBackPage = findViewById<Button>(R.id.go_back_button).setOnClickListener { goBackPage() }
        val sadFaceSound = MediaPlayer.create(this, R.raw.music)
        val sadFace = findViewById<ImageButton>(R.id.sad_face_image).setOnClickListener { turnOnMusic(sadFaceSound) }
    }

    private fun goBackPage() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

   private fun turnOnMusic(media: MediaPlayer) {
       if (media.isPlaying) {
           media.pause()
           media.seekTo(0)
       }
       media.start()
       // media.seekTo(1000) To start the sound from the first second

   }


}