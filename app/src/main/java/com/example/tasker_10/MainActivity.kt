package com.example.tasker_10

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    lateinit var sharedpreference: SharedPreferences
    lateinit var sharedPrefereceEditor: SharedPreferences.Editor
    val REQUEST_RESULT = "REQUEST_RESULT"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedpreference = getSharedPreferences("LogInfo", MODE_PRIVATE)
        sharedPrefereceEditor = sharedpreference.edit()

        var isLoggedIn = sharedpreference.getBoolean("islogged", false)

        if(isLoggedIn){
            val intent = Intent(this, LoginActivity::class.java)
            startActivityForResult(intent, 42)

        }else{
            intent = Intent(this, MainPage::class.java)
            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val isLoginSuccess = data?.getBooleanExtra("isreturned", false)
            if (isLoginSuccess == true) {
                val intent = Intent(this, MainPage::class.java)
                startActivity(intent)
            }
        }
    }

}