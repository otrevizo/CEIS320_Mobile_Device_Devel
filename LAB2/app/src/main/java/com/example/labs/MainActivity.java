package com.example.labs;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
        tempGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
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

}