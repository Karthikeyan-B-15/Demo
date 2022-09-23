package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class BMICalc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmicalc)
        val height=findViewById<EditText>(R.id.htext)
        val weight=findViewById<EditText>(R.id.wtext)
        val calc=findViewById<Button>(R.id.calc)
        calc.setOnClickListener {
            val display=findViewById<TextView>(R.id.dtext)
            display.setText((height.text.toString().toInt()+weight.text.toString().toInt()).toString())
        }
    }
}