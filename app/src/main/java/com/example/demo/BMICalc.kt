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
            val bmi=weight.text.toString().toFloat()/((height.text.toString().toFloat()/100)*height.text.toString().toFloat()/100)
            val bmidigit= String.format("%.2f",bmi).toFloat()
            display.setText(bmidigit.toString())
            height.setText("")
            weight.setText("")
        }
    }
}