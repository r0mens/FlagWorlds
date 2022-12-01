package com.roman_druck.flagworlds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_game_end.*
import kotlinx.android.synthetic.main.activity_main.*

class GameEndActivity : AppCompatActivity() {
    lateinit var m2AdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_end)
        MobileAds.initialize(this) {}
        m2AdView = findViewById(R.id.adView2)
        val adRequest = AdRequest.Builder().build()
        m2AdView.loadAd(adRequest)
    }
}