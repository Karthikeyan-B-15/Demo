package com.example.demo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var sharedPreference:SharedPreferences
    private lateinit var sharededit:SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        editText=findViewById(R.id.sharededit)
        sharedPreference=getSharedPreferences("data", MODE_PRIVATE)
        sharededit=sharedPreference.edit()
    }

    override fun onPause() {
        super.onPause()
        sharededit.putString("name",editText.text.toString())
        sharededit.apply()
    }

    override fun onResume() {
        super.onResume()
        editText.setText(sharedPreference.getString("name",null))

    }
}