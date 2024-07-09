# LAB2_MainActivity_java.md

## Java Code with Detailed Comments

```java
package com.example.labs;

import android.support.v7.app.AppCompatActivity; // Import the AppCompatActivity class
import android.os.Bundle; // Import the Bundle class
import android.widget.RadioGroup; // Import the RadioGroup class
import android.widget.TextView; // Import the TextView class

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {
    // MainActivity extends AppCompatActivity and implements RadioGroup.OnCheckedChangeListener

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
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // onCheckedChanged method is called when the checked radio button in the group changes
        // Find the TextView in the layout where the result will be displayed
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);

        // Use a switch statement to determine which radio button was checked
        switch (checkedId) {
            case R.id.btnDegF:
                // If the Fahrenheit button is checked, set the output text to "You chose Fahrenheit"
                lblOutput.setText("You chose Fahrenheit");
                break;
            case R.id.btnDegC:
                // If the Celsius button is checked, set the output text to "You chose Celsius"
                lblOutput.setText("You chose Celsius");
                break;
            case R.id.btnDegK:
                // If the Kelvin button is checked, set the output text to "You chose Kelvin"
                lblOutput.setText("You chose Kelvin");
                break;
        }
    }
}
```
# Detailed Comments Explanation

## Imports

The `import` statements bring in necessary classes from the Android SDK. These include `AppCompatActivity` for the activity class, `Bundle` for saving the state, `RadioGroup` for grouping radio buttons, and `TextView` for displaying text.

## Class Declaration

`MainActivity` extends `AppCompatActivity` to inherit functionality for an Android activity. It also implements `RadioGroup.OnCheckedChangeListener` to handle changes in the radio button group.

## onCreate Method

- `onCreate` is called when the activity is created. It initializes the activity.
  - `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
  - `setContentView(R.layout.activity_main)` sets the user interface layout for this activity.
  - `RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup)` finds the `RadioGroup` defined in the XML layout.
  - `tempGroup.setOnCheckedChangeListener(this)` sets the current instance as the listener for changes in the checked state of the radio buttons in the group.

## onCheckedChanged Method

- This method is called when the checked state of a radio button in the `RadioGroup` changes.
  - `TextView lblOutput = (TextView) findViewById(R.id.lblOutput)` finds the `TextView` defined in the XML layout where the result will be displayed.
  - The `switch` statement checks which radio button was selected using `checkedId` and updates the `TextView` accordingly.

## Summary

This code sets up an Android activity with a `RadioGroup` containing three radio buttons. When the user selects one of the radio buttons, the text of a `TextView` is updated to reflect the user's choice. The `@Override` annotations indicate that `onCreate` and `onCheckedChanged` methods are overriding methods from their respective parent classes or interfaces.

