package com.example.unitconverterapp

import Converter.convertLength
import Converter.convertWeight
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerFrom: Spinner
    private lateinit var spinnerTo: Spinner
    private lateinit var editTextValue: EditText
    private lateinit var textViewResult: TextView
    private lateinit var buttonConvert: Button

    private val unitsLength = arrayOf("Meters", "Kilometers", "Miles", "Yards")
    private val unitsWeight = arrayOf("Grams", "Kilograms", "Pounds", "Ounces")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerFrom = findViewById(R.id.spinner_from)
        spinnerTo = findViewById(R.id.spinner_to)
        editTextValue = findViewById(R.id.editText_value)
        textViewResult = findViewById(R.id.textView_result)
        buttonConvert = findViewById(R.id.button_convert)

        val adapterLength = ArrayAdapter(this, android.R.layout.simple_spinner_item, unitsLength)
        val adapterWeight = ArrayAdapter(this, android.R.layout.simple_spinner_item, unitsWeight)

        adapterLength.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapterWeight.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerFrom.adapter = adapterLength
        spinnerTo.adapter = adapterLength

        buttonConvert.setOnClickListener {
            val fromUnit = spinnerFrom.selectedItem.toString()
            val toUnit = spinnerTo.selectedItem.toString()
            val value = editTextValue.text.toString().toDoubleOrNull()
            if (value != null) {
                val result = if (fromUnit in unitsLength) {
                    Converter.convertLength(value, fromUnit, toUnit)
                } else {
                    Converter.convertWeight(value, fromUnit, toUnit)
                }
                textViewResult.text = result.toString()
            } else {
                textViewResult.text = getString(R.string.invalid_input)
            }
        }
    }
}
