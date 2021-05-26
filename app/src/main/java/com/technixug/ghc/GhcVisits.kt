package com.technixug.ghc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class GhcVisits : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ghc_visits)
        title = "Vists management"
    }
}