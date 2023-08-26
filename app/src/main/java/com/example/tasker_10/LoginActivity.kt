package com.example.tasker_10

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlin.system.exitProcess

class LoginActivity : AppCompatActivity() {

    lateinit var sharedpreference: SharedPreferences
    lateinit var sharedPrefereceEditor: SharedPreferences.Editor
    lateinit var LoginBtn : Button

    lateinit var UserNameET: EditText
    lateinit var PasswordET: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        UserNameET = findViewById(R.id.etUserName)
        PasswordET = findViewById(R.id.etPassword)
        LoginBtn = findViewById(R.id.btnLogin)

        LoginBtn.setOnClickListener{

            //check the login in the database
            sendSharedPreference()
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("isreturned", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }    }

    fun sendSharedPreference(){
        var username = UserNameET.text.toString()

        sharedpreference = getSharedPreferences("LogInfo", MODE_PRIVATE)
        sharedPrefereceEditor = sharedpreference.edit()

        sharedPrefereceEditor.apply{
            putString("UserName", username)
            putBoolean("islogged", true)
            commit()
        }
    }



}