# LAB2_InformationResultsActivity_java.md

## Java Code with Detailed Comments

```java
package com.example.ceis320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_results);

        // Retrieve the intent and get the data passed from the previous activity
        Intent intent = getIntent();
        String season = intent.getStringExtra("season");
        int temperature = intent.getIntExtra("temperature", 70); // If no int value exists, return the default value
        String allergies = intent.getStringExtra("allergies");

        // Get references to the TextViews
        TextView txtSeason = (TextView) findViewById(R.id.txtSeason);
        TextView txtTemperature = (TextView) findViewById(R.id.txtTemperature);
        TextView txtAllergies = (TextView) findViewById(R.id.txtAllergies);

        // Set the text for the TextViews based on the retrieved data
        txtSeason.setText("Your favorite season is " + season);
        txtTemperature.setText("Your favorite temperature is " + temperature);

        // Depending on whether the allergies are yes or no, determine the output of this TextView
        if (allergies.equals("Yes")) {
            txtAllergies.setText("Sorry that you have allergies");
        } else {
            txtAllergies.setText("You don't have allergies");
        }

        // Set up the button to go back to the main menu
        Button btnMain = (Button) findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goMain();
            }
        });
    }

    // Method to start the MainMenuActivity
    private void goMain() {
        Intent intent = new Intent(InformationResultsActivity.this, MainMenuActivity.class);
        this.startActivity(intent);
    }
}
```
## InformationResultsActivity.java Detailed Explanation

### Imports:
The import statements bring in necessary classes from the Android SDK and AndroidX libraries. These include:

- `AppCompatActivity` for the activity class.
- `Intent` for starting new activities and passing data between them.
- `Bundle` for saving the state.
- `View` for UI interactions.
- `Button` and `TextView` for the UI components.

### Class Declaration:
`InformationResultsActivity` extends `AppCompatActivity` to inherit functionality for an Android activity.

### onCreate Method:
`onCreate` is called when the activity is created. It initializes the activity.

- `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
- `setContentView(R.layout.activity_information_results)` sets the user interface layout for this activity.

#### Retrieve Data from Intent:
The activity retrieves data passed from the previous activity using the `Intent`:

- `intent.getStringExtra("season")` gets the season string.
- `intent.getIntExtra("temperature", 70)` gets the temperature integer, with a default value of 70 if none is provided.
- `intent.getStringExtra("allergies")` gets the allergies string.

#### Widget References:
Each UI element is initialized:

- `txtSeason` is a `TextView` to display the selected season.
- `txtTemperature` is a `TextView` to display the selected temperature.
- `txtAllergies` is a `TextView` to display the allergies status.

#### Set Text for TextViews:
The retrieved data is used to set the text for the `TextView` elements:

- `txtSeason.setText("Your favorite season is " + season)` sets the season.
- `txtTemperature.setText("Your favorite temperature is " + temperature)` sets the temperature.

#### Allergy Status:
The `TextView` for allergies is set based on whether the allergies string is "Yes" or "No":

- If `allergies.equals("Yes")`, set the text to "Sorry that you have allergies".
- Else, set the text to "You don't have allergies".

#### Button Click Listener:
A click listener is set up for the button to go back to the main menu:

- `btnMain.setOnClickListener(new View.OnClickListener() { ... })` sets the click listener for the button.
- The `goMain()` method is called when the button is clicked.

### goMain Method:
`goMain` starts the `MainMenuActivity`:

- `Intent intent = new Intent(InformationResultsActivity.this, MainMenuActivity.class)` creates an intent to start `MainMenuActivity`.
- `this.startActivity(intent)` starts the `MainMenuActivity`.

### Summary:
This code sets up an Android activity to display the results of information collected from the user in the previous activity. It retrieves data passed via an `Intent`, updates `TextView` elements with this data, and provides a button to return to the main menu.
