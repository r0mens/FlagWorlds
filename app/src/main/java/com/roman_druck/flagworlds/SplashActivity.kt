package com.roman_druck.flagworlds

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}