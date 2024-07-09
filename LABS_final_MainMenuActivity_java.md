# LABS_final_MainMenuActivity_java.md

## Java Code with Detailed Comments

```java
package com.example.ceis320;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Add a listener to the button to take you to the WeatherActivity
        Button btnWeather = (Button) findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goWeather();
            }
        });

        // Add a listener to the button to take you to the TestActivity
        Button btnDraw = (Button) findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTest();
            }
        });

        // Add a listener to the button to take you to the TicTacToeActivity
        Button btnTicTacToe = (Button) findViewById(R.id.btnTicTacToe);
        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTicTacToe();
            }
        });

        // Add a listener to the button to take you to the InformationPageActivity
        Button btnInfo = (Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goInfo();
            }
        });

        // Add a listener to the button to take you to the TakePictureActivity
        Button btnTakePic = (Button) findViewById(R.id.btnTakePic);
        btnTakePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTakePic();
            }
        });

        // Add a listener to the button to take you to the SongActivity
        Button btnFavSong = (Button) findViewById(R.id.btnSong);
        btnFavSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goSong();
            }
        });
    }

    private void goWeather() {
        Intent intent = new Intent(MainMenuActivity.this, WeatherActivity.class);
        this.startActivity(intent);
    }

    private void goDraw() {
        Intent intent = new Intent(MainMenuActivity.this, MyDrawing.class);
        this.startActivity(intent);
    }

    private void goTicTacToe() {
        Intent intent = new Intent(MainMenuActivity.this, TicTacToeActivity.class);
        this.startActivity(intent);
    }

    private void goInfo() {
        Intent intent = new Intent(MainMenuActivity.this, InformationPageActivity.class);
        this.startActivity(intent);
    }

    private void goSong() {
        Intent intent = new Intent(MainMenuActivity.this, SongActivity.class);
        this.startActivity(intent);
    }

    private void goTakePic() {
        Intent intent = new Intent(MainMenuActivity.this, TakePictureActivity.class);
        this.startActivity(intent);
    }

    private void goTest() {
        Intent intent = new Intent(MainMenuActivity.this, TestActivity.class);
        this.startActivity(intent);
    }
}
```
## Detailed Comments Explanation

### Imports:
The import statements bring in necessary classes from the Android SDK and AndroidX libraries. These include:

- `AppCompatActivity` for the activity class.
- `Intent` for starting new activities.
- `Bundle` for saving the state.
- `View` for UI interactions.
- `Button` for the button component.

### Class Declaration:
`MainMenuActivity` extends `AppCompatActivity` to inherit functionality for an Android activity.

### onCreate Method:
`onCreate` is called when the activity is created. It initializes the activity.

- `super.onCreate(savedInstanceState)` calls the superclass's method to perform default setup.
- `setContentView(R.layout.activity_main_menu)` sets the user interface layout for this activity.

#### Button Listeners:
Each button is initialized and a click listener is set to navigate to the corresponding activity:

- `Button btnWeather = (Button) findViewById(R.id.btnWeather)` finds the `Button` defined in the XML layout.
- `btnWeather.setOnClickListener(new View.OnClickListener() {...})` sets the current instance as the click listener for the `btnWeather` button to navigate to `WeatherActivity`.

Similarly, buttons for other activities (`TestActivity`, `TicTacToeActivity`, `InformationPageActivity`, `TakePictureActivity`, `SongActivity`) are set up with click listeners to navigate to their respective activities.

### Navigation Methods:
Each method starts a new activity using an `Intent`.

- `private void goWeather()` method to navigate to `WeatherActivity`.
  - `Intent intent = new Intent(MainMenuActivity.this, WeatherActivity.class)` creates an `Intent` to start `WeatherActivity`.
  - `this.startActivity(intent)` starts the `WeatherActivity`.

Similarly, methods for other activities (`goDraw`, `goTicTacToe`, `goInfo`, `goSong`, `goTakePic`, `goTest`) are defined to navigate to their respective activities.

### Summary:
This code sets up an Android activity with buttons to navigate to different activities. When the user clicks a button, the corresponding activity is started using an `Intent`. The `@Override` annotation indicates that `onCreate` is overriding a method from its superclass.
