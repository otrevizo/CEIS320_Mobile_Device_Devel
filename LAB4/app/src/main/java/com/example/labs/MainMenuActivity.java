package com.example.labs;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.labs.databinding.ActivityMainMenuBinding;

public class MainMenuActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainMenuBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        //Add a listener to the button to take you to the temp converter
        Button btnWeather=(Button) findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goWeather();
                                          }
                                      }
        );

        //Add a listener to the button to take you to the temp converter
        Button btnDraw=(Button) findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goDrawing();
                                          }
                                      }
        );

        // NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_menu);
        // appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        // NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void goWeather() {
        Intent intent = new Intent(MainMenuActivity.this, WeatherActivity.class);
        this.startActivity(intent);
    }

    private void goDrawing() {
        Intent intent = new Intent(MainMenuActivity.this, MyDrawing.class);
        this.startActivity(intent);
    }

  //  @Override
 //   public boolean onSupportNavigateUp() {
 //       NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main_menu);
 //       return NavigationUI.navigateUp(navController, appBarConfiguration)
 //               || super.onSupportNavigateUp();
 //   }
}