package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.android.synthetic.main.activity_second.textView
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {

    companion object {
        const val TOTAL_COUNT = "total_count"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val num = intent.getIntExtra(TOTAL_COUNT, 0)
        textViewRandom.text = random(num).toString()
        textView.text = "Random number within 0 and $num"
    }

    fun random(int: Int): Int {
        val nextInt = Random.nextInt(int)
        return nextInt
    }
}