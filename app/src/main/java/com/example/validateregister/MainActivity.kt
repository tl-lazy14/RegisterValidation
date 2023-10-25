package com.example.validateregister

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.constraint_layout)

        val inputFirstName : EditText = findViewById(R.id.inputFirstName)
        val inputLastName : EditText = findViewById(R.id.inputLastName)
        val radioButtonMale : RadioButton = findViewById(R.id.radioButtonMale)
        val radioButtonFemale : RadioButton = findViewById(R.id.radioButtonFemale)
        val inputBirthday : EditText = findViewById(R.id.inputBirthday)
        val inputAddress : EditText = findViewById(R.id.inputAddress)
        val inputEmail : EditText = findViewById(R.id.inputEmail)
        val checkboxTerm : CheckBox = findViewById(R.id.termsCheckbox)

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerButton : Button = findViewById(R.id.selectDateButton)

        datePickerButton.setOnClickListener {
            val datePickerDialog = DatePickerDialog(
                this,
                { _, year, month, dayOfMonth ->
                    val selectedDate = "$year-${month + 1}-$dayOfMonth"
                    inputBirthday.setText(selectedDate)
                },
                year, month, day
            )
            datePickerDialog.show()
        }

        val registerBtn : Button = findViewById(R.id.registerButton)
        registerBtn.setOnClickListener {
            val firstName = inputFirstName.text.toString()
            val lastName = inputLastName.text.toString()
            val birthday = inputBirthday.text.toString()
            val address = inputAddress.text.toString()
            val email = inputEmail.text.toString()
            if (firstName.isEmpty() || lastName.isEmpty() || birthday.isEmpty() || address.isEmpty()
                || email.isEmpty() || !checkboxTerm.isChecked || (!radioButtonMale.isChecked && !radioButtonFemale.isChecked)) {
                Toast.makeText(this, "Please fill out all information fields", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "Register Successfully!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}