package com.android.amigo.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.amigo.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }
}