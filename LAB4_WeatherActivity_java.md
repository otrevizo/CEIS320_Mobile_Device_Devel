# Weatherctivity.java

```java
package com.example.labs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class WeatherActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, OnClickListener {

    // Declare variables
    private RadioButton btnFah;
    private RadioButton btnCel;
    private RadioButton btnKel ;
    private EditText txtInputTemp;
    private TextView lblOutputDegF;
    private TextView lblOutputDegC;
    private TextView lblOutputDegK;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        
        // Initialize the RadioGroup and set a listener for checked state changes
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
        tempGroup.setOnCheckedChangeListener(this);

        // Initialize the convert button and set a click listener
        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Get Resources for radio buttons, text boxes, and labels
        btnFah = (RadioButton) findViewById(R.id.btnDegF);
        btnCel = (RadioButton) findViewById(R.id.btnDegC);
        btnKel = (RadioButton) findViewById(R.id.btnDegK);
        txtInputTemp = (EditText) findViewById(R.id.txtInputTemp);
        lblOutputDegF = (TextView) findViewById(R.id.lblOutputF);
        lblOutputDegC = (TextView) findViewById(R.id.lblOutputC);
        lblOutputDegK = (TextView) findViewById(R.id.lblOutputK);

        // Convert the input temperature to double
        double temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()));
        double answer = 0;

        // If the user chose Fahrenheit, convert to Celsius and Kelvin and display in those text boxes
        if (btnFah.isChecked()) {
            lblOutputDegF.setText(temp + " degrees F");
            lblOutputDegC.setText((Math.round((temp - 32) * 5 / 9 * 100.0) / 100.0) + " degrees C");
            lblOutputDegK.setText((Math.round((temp + 459.67) * 5 / 9 * 100.0) / 100.0) + " degrees K");
        }

        // If the user chose Celsius, convert to Fahrenheit and Kelvin and display in those text boxes
        if (btnCel.isChecked()) {
            lblOutputDegF.setText((Math.round(((temp * 9) / 5 + 32) * 100.0) / 100.0) + " degrees F");
            lblOutputDegC.setText(temp + " degrees C");
            lblOutputDegK.setText((Math.round((temp + 273.15) * 100.0) / 100.0) + " degrees K");
        }

        // If the user chose Kelvin, convert to Fahrenheit and Celsius and display in those text boxes
        if (btnKel.isChecked()) {
            lblOutputDegF.setText((Math.round((temp * 9 / 5 - 459.67) * 100.0) / 100.0) + " degrees F");
            lblOutputDegC.setText((Math.round((temp - 273.15) * 100.0) / 100.0) + " degrees C");
            lblOutputDegK.setText(temp + " degrees K");
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        // Display the chosen temperature unit in a label
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
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

    // @Override
    // public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    // switch(item.getItemId()) {
    // case R.id.mnuMain:
    // startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
    // return true;
    // case R.id.mnuExit:
    // finish();
    // default:
    // return super.onOptionsItemSelected(item);
    // }
    // }
}
```
## Detailed Comments Explanation

### Imports:
The import statements bring in necessary classes from the Android SDK and AndroidX libraries. These include:

- `AppCompatActivity` for the activity class.
- `Bundle` for saving the state.
- `View` for UI interactions.
- `Button` for the button component.
- `EditText` for input text fields.
- `RadioButton` for radio button components.
- `RadioGroup` for grouping radio buttons.
- `TextView` for displaying text.
- `OnClickListener` for handling click events.

### Class Declaration:
`WeatherActivity` extends `AppCompatActivity` to inherit functionality for an Android activity. It also implements `RadioGroup.OnCheckedChangeListener` to handle changes in the radio button group and `View.OnClickListener` to handle button click events.

### onCreate Method:
`onCreate` is called when the activity is created. It initializes the activity.
- `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
- `setContentView(R.layout.activity_weather)` sets the user interface layout for this activity.
- `RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup)` finds the `RadioGroup` defined in the XML layout.
- `tempGroup.setOnCheckedChangeListener(this)` sets the current instance as the listener for changes in the checked state of the radio buttons in the group.
- `Button btnConvert = (Button) findViewById(R.id.btnConvert)` finds the `Button` defined in the XML layout.
- `btnConvert.setOnClickListener(this)` sets the current instance as the click listener for the `Button`.

### onClick Method:
This method is called when the `Button` is clicked.
- `btnFah = (RadioButton) findViewById(R.id.btnDegF)` finds the `RadioButton` for Fahrenheit.
- `btnCel = (RadioButton) findViewById(R.id.btnDegC)` finds the `RadioButton` for Celsius.
- `btnKel = (RadioButton) findViewById(R.id.btnDegK)` finds the `RadioButton` for Kelvin.
- `txtInputTemp = (EditText) findViewById(R.id.txtInputTemp)` finds the `EditText` for inputting the temperature.
- `lblOutputDegF = (TextView) findViewById(R.id.lblOutputF)` finds the `TextView` for displaying Fahrenheit.
- `lblOutputDegC = (TextView) findViewById(R.id.lblOutputC)` finds the `TextView` for displaying Celsius.
- `lblOutputDegK = (TextView) findViewById(R.id.lblOutputK)` finds the `TextView` for displaying Kelvin.
- `double temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()))` converts the input temperature to a double.

The `if` statements check which radio button is selected and perform the corresponding conversions. The converted values are then displayed in the respective `TextViews`.

### onCheckedChanged Method:
This method is called when the checked state of a radio button in the `RadioGroup` changes.
- `TextView lblOutput = (TextView) findViewById(R.id.lblOutput)` finds the `TextView` defined in the XML layout where the result will be displayed.
- The `switch` statement checks which radio button was selected using `checkedId` and updates the `TextView` accordingly.

### Summary:
This code sets up an Android activity with a `RadioGroup` containing three radio buttons and a `Button` to convert temperatures. When the user selects one of the radio buttons, the text of a `TextView` is updated to reflect the user's choice. When the user clicks the `Button`, the input temperature is converted to the other two scales. The `@Override` annotations indicate that `onCreate`, `onClick`, and `onCheckedChanged` methods are overriding methods from their respective parent classes or interfaces.
