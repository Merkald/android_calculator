package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toastMe(view: View) {
        val myToast = Toast.makeText(this,"Hello toast",Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe(view: View) {
        val countString = textView.text.toString()
        var count:Int = Integer.parseInt(countString)
        count++
        textView.text = count.toString()
    }

    fun random(view: View) {
        val randomIntent = Intent(this,SecondActivity::class.java)
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, Integer.parseInt(textView.text.toString()))
        startActivity(randomIntent)
    }

    fun calculator(view: View) {
        val calculatorIntent = Intent(this,Calculator::class.java)
        startActivity(calculatorIntent)
    }
}