package com.example.myapplication

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.service.Calculate
import kotlinx.android.synthetic.main.activity_calculator2.*
import org.w3c.dom.Text

class Calculator : AppCompatActivity() {

    var checker = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator2)
    }

    fun add1(view: View) {
        var num: String = getTextView().text.toString()
        num += 1
        getTextView().text = num
    }

    fun add2(view: View) {
        var num: String = getTextView().text.toString()
        num += 2
        getTextView().text = num
    }

    fun add3(view: View) {
        var num: String = getTextView().text.toString()
        num += 3
        getTextView().text = num
    }

    fun add4(view: View) {
        var num: String = getTextView().text.toString()
        num += 4
        getTextView().text = num
    }

    fun add5(view: View) {
        var num: String = getTextView().text.toString()
        num += 5
        getTextView().text = num
    }

    fun add6(view: View) {
        var num: String = getTextView().text.toString()
        num += 6
        getTextView().text = num
    }

    fun add7(view: View) {
        var num: String = getTextView().text.toString()
        num += 7
        getTextView().text = num
    }

    fun add8(view: View) {
        var num: String = getTextView().text.toString()
        num += 8
        getTextView().text = num
    }

    fun add9(view: View) {
        var num: String = getTextView().text.toString()
        num += 9
        getTextView().text = num
    }

    fun add0(view: View) {
        var num: String = getTextView().text.toString()
        num += 0
        getTextView().text = num
    }

    fun addDot(view: View) {
        var num: String = getTextView().text.toString()
        if (num.length == 0) {
            num = "0."
        }
        if (!num.contains('.', true)) {
            num += "."
        }
        getTextView().text = num
    }

    fun addPlus(view: View) {
        if (!checkStrings()[checker]
        ) {
            Toast.makeText(this, "Write first number!", Toast.LENGTH_SHORT).show()
        } else {
            symbolView.text = "+"
            checker = 2
        }
    }

    fun addminus(view: View) {
        when (getTextView().text) {
            "" -> getTextView().text = "-"
            "-" -> getTextView().text = ""
            else -> {
                symbolView.text = "-"
                checker = 2
            }
        }
    }

    fun addmultiply(view: View) {
        if (!checkStrings()[checker]
        ) {
            Toast.makeText(this, "Write first number!", Toast.LENGTH_SHORT).show()
        } else {
            symbolView.text = "*"
            checker = 2
        }
    }

    fun addDivide(view: View) {
        if (!checkStrings()[checker]) {
            Toast.makeText(this, "Write first number!", Toast.LENGTH_SHORT).show()
        } else {
            symbolView.text = "/"
            checker = 2
        }
    }

    fun getResult(view: View) {
        if (checkStrings()[0] && checkStrings()[1] && checkStrings()[2]) {
            var calculate: Calculate = Calculate()
            resultTextView.text = calculate.calculate(
                textViewNumbers.text.toString(),
                textViewNumbers2.text.toString(),
                symbolView.text.toString()
            ).toString()
        } else {
            Toast.makeText(this, "Write correct equation!", Toast.LENGTH_SHORT).show()
        }
    }

    fun clean(view: View) {
        textViewNumbers.text = ""
        textViewNumbers2.text = ""
        symbolView.text = ""
        resultTextView.text = ""
        checker = 1
    }

    fun getTextView(): TextView {
        when (checker) {
            1 -> return textViewNumbers
            2 -> return textViewNumbers2
        }
        return textViewNumbers
    }

    fun checkStrings(): Array<Boolean> {
        val text1 = textViewNumbers.text.toString()
        val text2 = textViewNumbers2.text.toString()
        val sybbol = symbolView.text.toString()
        var result: Array<Boolean> = arrayOf(false, false, false);
        result[1] =
            text1.length != 0 && !text1.equals("-") && !text1.get(text1.length - 1).equals('.')
        result[2] =
            text2.length != 0 && !text2.equals("-") && !text2.get(text2.length - 1).equals('.')
        result[0] = sybbol.length == 1
        return result
    }
}