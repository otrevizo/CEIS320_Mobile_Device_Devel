package com.example.ceis320redover4;

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

        //Add a listener to the button to take you to the temp converter
        Button btnWeather=(Button) findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goWeather();
                                          }
                                      }
        );

        Button btnDraw=(Button) findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goDraw();
                                          }
                                      }
        );

        Button btnTicTacToe=(Button) findViewById(R.id.btnTicTacToe);
        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goTicTacToe();
                                          }
                                      }
        );

        Button btnInfo=(Button) findViewById(R.id.btnInfo);
        btnInfo.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           goInfo();
                                       }
                                   }
        );
        Button btnTakePic=(Button) findViewById(R.id.btnTakePic);
        btnTakePic.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goTakePic();
                                          }
                                      }
        );

        Button btnFavSong=(Button) findViewById(R.id.btnSong);
        btnFavSong.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              goSong();
                                          }
                                      }
        );

    }

    private void goWeather() {
        Intent intent = new Intent(MainMenuActivity.this, WeatherActivity.class);
        this.startActivity(intent);
    }
    private void goDraw() {
        Intent intent = new Intent(MainMenuActivity.this,MyDrawing.class);
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
}