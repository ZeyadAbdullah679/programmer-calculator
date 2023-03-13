package com.example.programmercalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.example.programmer_calculator.R

class MainActivity : AppCompatActivity() {

    lateinit var binary: EditText
    lateinit var octal: EditText
    lateinit var decimal: EditText
    lateinit var hexadecimal: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        converter()
    }

    private fun converter() {
        binaryConverter()
        octalConverter()
        decimalConverter()
        hexadecimalConverter()
    }

    private fun binaryConverter() {
        binary.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (binary.hasFocus() && s != null && s.isNotBlank()) {
                    val bin = s.toString().toLong(2)
                    octal.setText(bin.toString(8))
                    decimal.setText(bin.toString(10))
                    hexadecimal.setText(bin.toString(16))
                } else if (binary.hasFocus() && s!!.isBlank()) {
                    octal.setText("")
                    decimal.setText("")
                    hexadecimal.setText("")
                }
            }
        })
    }

    private fun octalConverter() {
        octal.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (octal.hasFocus() && s != null && s.isNotBlank()) {
                    val oct = s.toString().toLong(8)
                    binary.setText(oct.toString(2))
                    decimal.setText(oct.toString(10))
                    hexadecimal.setText(oct.toString(16))
                }
                else if (octal.hasFocus() && s!!.isBlank()) {
                    binary.setText("")
                    decimal.setText("")
                    hexadecimal.setText("")
                }
            }
        })
    }

    private fun decimalConverter() {
        decimal.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (decimal.hasFocus() && s != null && s.isNotBlank()) {
                    val dec = s.toString().toLong(10)
                    binary.setText(dec.toString(2))
                    octal.setText(dec.toString(8))
                    hexadecimal.setText(dec.toString(16))
                }
                else if (decimal.hasFocus() && s!!.isBlank()) {
                    binary.setText("")
                    octal.setText("")
                    hexadecimal.setText("")
                }
            }
        })
    }

    private fun hexadecimalConverter() {
        hexadecimal.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (hexadecimal.hasFocus() && s != null && s.isNotBlank()) {
                    val hex = s.toString().toLong(16)
                    binary.setText(hex.toString(2))
                    octal.setText(hex.toString(8))
                    decimal.setText(hex.toString(10))
                }
                else if (hexadecimal.hasFocus() && s!!.isBlank()) {
                    binary.setText("")
                    octal.setText("")
                    decimal.setText("")
                }
            }
        })
    }

    private fun setValues() {
        binary = findViewById(R.id.binary)
        octal = findViewById(R.id.octal)
        decimal = findViewById(R.id.decimal)
        hexadecimal = findViewById(R.id.hexadecimal)
    }

}