# LAB2_InformationPageActivity_java.md

## Java Code with Detailed Comments

```java
package com.example.ceis320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class InformationPageActivity extends AppCompatActivity implements View.OnClickListener {
    // Declare UI elements
    Button btnSave;
    Spinner spnSeason;
    SeekBar skbTemp;
    Switch swchAllergy;
    TextView lblSeekValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);

        // Initialize UI elements
        spnSeason = (Spinner) findViewById(R.id.spnSeason);
        skbTemp = (SeekBar) findViewById(R.id.skbTemp);
        swchAllergy = (Switch) findViewById(R.id.swchAllergy);
        lblSeekValue = (TextView) findViewById(R.id.lblSeekValue);
        btnSave = (Button) findViewById(R.id.btnSave);

        // Set click listener for the save button
        btnSave.setOnClickListener(this);

        // Set seek bar change listener
        skbTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Update label with the current seek bar value
                String display = String.valueOf(progress);
                lblSeekValue.setText(display);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Optional: Implement if needed
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Optional: Implement if needed
            }
        });
    }

    @Override
    public void onClick(View v) {
        // Retrieve data from UI elements
        String season, allergies;
        int temperature;
        season = spnSeason.getSelectedItem().toString();
        temperature = skbTemp.getProgress();
        allergies = (String) (swchAllergy.isChecked() ? swchAllergy.getTextOn() : swchAllergy.getTextOff()); // If the switch is on then the user has allergies

        // Create intent to start InformationResultsActivity and pass data
        Intent intent = new Intent(InformationPageActivity.this, InformationResultsActivity.class);
        intent.putExtra("season", season);
        intent.putExtra("temperature", temperature);
        intent.putExtra("allergies", allergies);
        this.startActivity(intent);
    }
}
```
## InformationPageActivity.java Detailed Explanation

### Imports:
The import statements bring in necessary classes from the Android SDK and AndroidX libraries. These include:

- `AppCompatActivity` for the activity class.
- `Intent` for starting new activities.
- `Bundle` for saving the state.
- `View` for UI interactions.
- `Button`, `SeekBar`, `Spinner`, `Switch`, and `TextView` for the UI components.

### Class Declaration:
`InformationPageActivity` extends `AppCompatActivity` to inherit functionality for an Android activity. It implements `View.OnClickListener` to handle click events.

### onCreate Method:
`onCreate` is called when the activity is created. It initializes the activity.

- `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
- `setContentView(R.layout.activity_information_page)` sets the user interface layout for this activity.

#### Widget References:
Each UI element is initialized:

- `spnSeason` is a `Spinner` to select a season.
- `skbTemp` is a `SeekBar` to select a temperature.
- `swchAllergy` is a `Switch` to indicate if the user has allergies.
- `lblSeekValue` is a `TextView` to display the current value of the `SeekBar`.
- `btnSave` is a `Button` to save the data.

#### Event Handlers:
Event handlers are set up for the `Button` and `SeekBar`:

- `btnSave.setOnClickListener(this)` sets the current instance as the click listener for the save button.
- `skbTemp.setOnSeekBarChangeListener` sets the listener for changes to the seek bar's progress.

#### SeekBar Change Listener:
Handles changes to the `SeekBar`'s progress:

- `onProgressChanged` updates `lblSeekValue` with the current value of the seek bar.
- `onStartTrackingTouch` and `onStopTrackingTouch` are optional methods that can be implemented if needed.

### onClick Method:
`onClick` handles click events for the save button:

- Retrieves data from the `Spinner`, `SeekBar`, and `Switch`.
- Creates an `Intent` to start `InformationResultsActivity` and passes the retrieved data as extras.

### Summary:
This code sets up an Android activity to collect information from the user. It initializes UI elements, handles user interactions, and passes collected data to another activity. When the save button is clicked, the current values from the `Spinner`, `SeekBar`, and `Switch` are retrieved and passed to `InformationResultsActivity` using an `Intent`.
