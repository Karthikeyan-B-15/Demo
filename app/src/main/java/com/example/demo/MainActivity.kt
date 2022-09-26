package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text = findViewById<TextView>(R.id.textView)
        val btn = findViewById<Button>(R.id.button)
        val nbtn=findViewById<Button>(R.id.nav)
        val bbtn=findViewById<Button>(R.id.bmi)
        val vbtn=findViewById<Button>(R.id.vbtn)
        btn.setOnClickListener {
            text.text = "Karthi"
        }
        nbtn.setOnClickListener {
            val intent =Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
        bbtn.setOnClickListener {
            val intent= Intent(this,BMICalc::class.java)
            startActivity(intent)
        }
        vbtn.setOnClickListener {
            val intent=Intent(this,MMedia::class.java)
            startActivity(intent)
        }
    }
}