# LAB3_MainActivity_java.md

## Java Code with Detailed Comments

```java
package com.example.labs;

import android.support.v7.app.AppCompatActivity; // Import the AppCompatActivity class
import android.os.Bundle; // Import the Bundle class
import android.view.View; // Import the View class
import android.widget.Button; // Import the Button class
import android.widget.EditText; // Import the EditText class
import android.widget.RadioButton; // Import the RadioButton class
import android.widget.RadioGroup; // Import the RadioGroup class
import android.widget.TextView; // Import the TextView class
import android.view.View.OnClickListener; // Import the OnClickListener interface

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, OnClickListener {
    // MainActivity extends AppCompatActivity and implements RadioGroup.OnCheckedChangeListener and View.OnClickListener

    // Declare variables for UI components
    private RadioButton btnFah;
    private RadioButton btnCel;
    private RadioButton btnKel;
    private EditText txtInputTemp;
    private TextView lblOutputDegF;
    private TextView lblOutputDegC;
    private TextView lblOutputDegK;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // onCreate method is called when the activity is first created
        super.onCreate(savedInstanceState);
        // Call the superclass's onCreate method to perform default initialization
        setContentView(R.layout.activity_main);
        // Set the user interface layout for this activity from activity_main.xml

        // Find the RadioGroup in the layout
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
        // Set the current instance (this) as the listener for when the checked radio button changes
        tempGroup.setOnCheckedChangeListener(this);

        // Find the Convert button in the layout
        btnConvert = (Button) findViewById(R.id.btnConvert);
        // Set the current instance (this) as the click listener for the Convert button
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // onClick method is called when the Convert button is clicked

        // Get references to the radio buttons, text input, and output labels
        btnFah = (RadioButton) findViewById(R.id.btnDegF);
        btnCel = (RadioButton) findViewById(R.id.btnDegC);
        btnKel = (RadioButton) findViewById(R.id.btnDegK);
        txtInputTemp = (EditText) findViewById(R.id.txtInputTemp);
        lblOutputDegF = (TextView) findViewById(R.id.lblOutputF);
        lblOutputDegC = (TextView) findViewById(R.id.lblOutputC);
        lblOutputDegK = (TextView) findViewById(R.id.lblOutputK);

        // Convert the input temperature to a double
        double temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()));

        // Check which radio button is selected and perform the corresponding conversions
        if (btnFah.isChecked()) {
            // If the Fahrenheit button is checked, convert to Celsius and Kelvin and display in the respective text boxes
            lblOutputDegF.setText(temp + " degrees F");
            lblOutputDegC.setText((Math.round((temp - 32) * 5 / 9 * 100.0) / 100.0) + " degrees C");
            lblOutputDegK.setText((Math.round((temp + 459.67) * 5 / 9 * 100.0) / 100.0) + " degrees K");
        } else if (btnCel.isChecked()) {
            // If the Celsius button is checked, convert to Fahrenheit and Kelvin and display in the respective text boxes
            lblOutputDegF.setText((Math.round(((temp * 9) / 5 + 32) * 100.0) / 100.0) + " degrees F");
            lblOutputDegC.setText(temp + " degrees C");
            lblOutputDegK.setText((Math.round((temp + 273.15) * 100.0) / 100.0) + " degrees K");
        } else if (btnKel.isChecked()) {
            // If the Kelvin button is checked, convert to Fahrenheit and Celsius and display in the respective text boxes
            lblOutputDegF.setText((Math.round((temp * 9 / 5 - 459.67) * 100.0) / 100.0) + " degrees F");
            lblOutputDegC.setText((Math.round((temp - 273.15) * 100.0) / 100.0) + " degrees C");
            lblOutputDegK.setText(temp + " degrees K");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // onCheckedChanged method is called when the checked radio button in the group changes

        // Find the TextView in the layout where the result will be displayed
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);

        // Use a switch statement to determine which radio button was checked and update the TextView accordingly
        switch (checkedId) {
            case R.id.btnDegF:
                lblOutput.setText("You chose Fahrenheit");
                break;
            case R.id.btnDegC:
                lblOutput.setText("You chose Celsius");
                break;
            case R.id.btnDegK:
                lblOutput.setText("You chose Kelvin");
                break;
        }
    }
}
```
# Detailed Comments Explanation

## Imports

The `import` statements bring in necessary classes from the Android SDK. These include `AppCompatActivity` for the activity class, `Bundle` for saving the state, `View` for UI interactions, `Button` for the button component, `EditText` for input text fields, `RadioButton` for radio button components, `RadioGroup` for grouping radio buttons, `TextView` for displaying text, and `OnClickListener` for handling click events.

## Class Declaration

`MainActivity` extends `AppCompatActivity` to inherit functionality for an Android activity. It also implements `RadioGroup.OnCheckedChangeListener` to handle changes in the radio button group and `View.OnClickListener` to handle button click events.

## onCreate Method

- `onCreate` is called when the activity is created. It initializes the activity.
  - `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
  - `setContentView(R.layout.activity_main)` sets the user interface layout for this activity.
  - `RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup)` finds the `RadioGroup` defined in the XML layout.
  - `tempGroup.setOnCheckedChangeListener(this)` sets the current instance as the listener for changes in the checked state of the radio buttons in the group.
  - `Button btnConvert = (Button) findViewById(R.id.btnConvert)` finds the `Button` defined in the XML layout.
  - `btnConvert.setOnClickListener(this)` sets the current instance as the click listener for the `Button`.

## onClick Method

- This method is called when the `Button` is clicked.
  - `btnFah = (RadioButton) findViewById(R.id.btnDegF)` finds the `RadioButton` for Fahrenheit.
  - `btnCel = (RadioButton) findViewById(R.id.btnDegC)` finds the `RadioButton` for Celsius.
  - `btnKel = (RadioButton) findViewById(R.id.btnDegK)` finds the `RadioButton` for Kelvin.
  - `txtInputTemp = (EditText) findViewById(R.id.txtInputTemp)` finds the `EditText` for inputting the temperature.
  - `lblOutputDegF = (TextView) findViewById(R.id.lblOutputF)` finds the `TextView` for displaying Fahrenheit.
  - `lblOutputDegC = (TextView) findViewById(R.id.lblOutputC)` finds the `TextView` for displaying Celsius.
  - `lblOutputDegK = (TextView) findViewById(R.id.lblOutputK)` finds the `TextView` for displaying Kelvin.
  - `double temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()))` converts the input temperature to a double.
  - The `if` statements check which radio button is selected and perform the corresponding conversions. The converted values are then displayed in the respective `TextView`s.

## onCheckedChanged Method

- This method is called when the checked state of a radio button in the `RadioGroup` changes.
  - `TextView lblOutput = (TextView) findViewById(R.id.lblOutput)` finds the `TextView` defined in the XML layout where the result will be displayed.
  - The `switch` statement checks which radio button was selected using `checkedId` and updates the `TextView` accordingly.

## Summary

This code sets up an Android activity with a `RadioGroup` containing three radio buttons and a `Button` to convert temperatures. When the user selects one of the radio buttons, the text of a `TextView` is updated to reflect the user's choice. When the user clicks the `Button`, the input temperature is converted to the other two scales.
