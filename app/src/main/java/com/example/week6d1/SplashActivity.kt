package com.example.week6d1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        moveToLoginScreen()
    }
    private fun moveToLoginScreen(){
        Handler(Looper.myLooper()!!).postDelayed({
            finish()
            val i=Intent(this,LogActivity::class.java)
            startActivity(i)
        },3000)


    }
}