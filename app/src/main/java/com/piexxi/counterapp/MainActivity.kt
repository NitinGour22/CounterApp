package com.piexxi.counterapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tv_count: TextView
    private lateinit var et_inputNumber: EditText
    private lateinit var bt_numberSubmit: Button
    private lateinit var bt_randomNumber: Button
    private lateinit var bt_decrement: Button
    private lateinit var bt_increment: Button
    private lateinit var et_diffNumber: EditText
    private lateinit var tv_summary: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
    }

    private fun init() {
        initView()
        initListners()
    }

    private fun initView() {

        tv_count = findViewById(R.id.tv_count)
        et_inputNumber = findViewById(R.id.et_input_number)
        bt_numberSubmit = findViewById(R.id.bt_number_submit)
        bt_randomNumber = findViewById(R.id.bt_random_number)
        bt_decrement = findViewById(R.id.bt_decrement_number)
        bt_increment = findViewById(R.id.bt_increment_number)
        et_diffNumber = findViewById(R.id.et_diff_number)
        tv_summary = findViewById(R.id.tv_summary_count)

    }

    private fun initListners() {

        bt_numberSubmit.setOnClickListener { submitNumber() }
        bt_randomNumber.setOnClickListener { generateRandomNumber() }
        bt_decrement.setOnClickListener { changeNumber("-") }
        bt_increment.setOnClickListener { changeNumber("+") }
    }

    private fun submitNumber() {

        var startingNumber = et_inputNumber.text.toString()

        if (startingNumber == "") {
            startingNumber = "10"
        }

        tv_count.text = startingNumber

        et_inputNumber.setText("")

        tv_summary.text = "You Selected $startingNumber "
        hideKeyboard()
    }

    private fun generateRandomNumber() {

        val randomNumber = (-100..100).random()
        tv_count.text = randomNumber.toString()
    }

    /* private fun incrrement() {

         val currentNumber = tv_count.text.toString().toInt()
         var incrementValue = et_diffNumber.text.toString()

         if (incrementValue == "") {
             incrementValue = "1"
         }

         val newNumber = currentNumber + incrementValue.toInt()
         tv_summary.text = "$currentNumber + $incrementValue = $newNumber"

     }

     private fun decrement() {
         val currentNumber = tv_count.text.toString().toInt()
         var incrementValue = et_diffNumber.text.toString()

         if (incrementValue == "") {
             incrementValue = "1"
         }

         val newNumber = currentNumber - incrementValue.toInt()
         tv_summary.text = "$currentNumber - $incrementValue = $newNumber"
     }
 */
    private fun changeNumber(operation: String) {
        val currentNumber = tv_count.text.toString().toInt()
        var incrementValue = et_diffNumber.text.toString()

        if (incrementValue == "") {
            incrementValue = "1"
        }

        if (operation == "+") {
            val newNumber = currentNumber + incrementValue.toInt()
            tv_count.text = newNumber.toString()
            tv_summary.text = " $currentNumber + $incrementValue = $newNumber "
        } else {
            val newNumber = currentNumber - incrementValue.toInt()
            tv_count.text = newNumber.toString()
            tv_summary.text = "$currentNumber - $incrementValue = $newNumber"
        }

        hideKeyboard()
    }

    private fun hideKeyboard() {
        var imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(et_inputNumber.windowToken, 0)
    }
}