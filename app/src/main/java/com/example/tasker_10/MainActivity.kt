package com.example.tasker_10

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class MainActivity : AppCompatActivity() {
    lateinit var sharedpreference: SharedPreferences
    lateinit var sharedPrefereceEditor: SharedPreferences.Editor


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpreference = getSharedPreferences("LogInfo", MODE_PRIVATE)
        sharedPrefereceEditor = sharedpreference.edit()

        var isLoggedIn = sharedpreference.getBoolean("islogged", false)

        if(isLoggedIn){
            intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }else{
            intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }

    }

}