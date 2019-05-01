package com.example.wrl123u.drinkrecipes;

import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Estimator extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_estimator);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        EditText starting = findViewById(R.id.beer_txt);
        starting.requestFocus();
        Button calc = findViewById(R.id.calc_btn);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double beers;
                Double wines;
                Double shots;
                Double weight;
                Double time;
                final RadioGroup sexGroup = findViewById(R.id.sex);
                int selectedId = sexGroup.getCheckedRadioButtonId();
                RadioButton sexChoice = findViewById(selectedId);
                String sex = sexChoice.getText().toString();
                double sexMultiplier;
                EditText beerTxt = findViewById(R.id.beer_txt);
                String beerTxtString = beerTxt.getText().toString();
                if(beerTxtString != null && !beerTxtString.isEmpty()) {
                    beers = Double.parseDouble(beerTxt.getText().toString());
                } else {
                   beers = 0.0;
                }
                EditText wineTxt = findViewById(R.id.wine_txt);
                String wineTxtString = wineTxt.getText().toString();
                if(wineTxtString != null && !wineTxtString.isEmpty()) {
                    wines = Double.parseDouble(wineTxt.getText().toString());
                } else {
                    wines = 0.0;
                }
                EditText shotTxt = findViewById(R.id.shot_txt);
                String shotTxtString = shotTxt.getText().toString();
                if(shotTxtString != null && !shotTxtString.isEmpty()){
                    shots = Double.parseDouble(shotTxt.getText().toString());
                } else {
                    shots = 0.0;
                }
                EditText weightTxt = findViewById(R.id.weight_txt);
                String weightTxtString = weightTxt.getText().toString();
                if(weightTxtString !=null && !weightTxtString.isEmpty()) {
                    weight = Double.parseDouble(weightTxt.getText().toString());
                } else {
                    weight = 0.0;
                }
                EditText timeTxt = findViewById(R.id.hours_txt);
                String timeTxtString = timeTxt.getText().toString();
                if(timeTxtString != null && !timeTxtString.isEmpty()) {
                    time = Double.parseDouble(timeTxt.getText().toString());
                } else {
                    time = 0.0;
                }

                double rawBac;
                double actualBac;
                final TextView resultTxt = findViewById(R.id.result_text);

                if(sex.equals("Man")) {
                    sexMultiplier = 0.68;
                } else {
                    sexMultiplier = 0.55;
                }

                double gramsAlcohol = (beers + wines + shots) * 14;
                weight = weight * 453.592 * sexMultiplier;
                rawBac = gramsAlcohol / weight * 100;
                actualBac = rawBac - (time * 0.015);

                if(Double.isNaN(actualBac)) {
                    actualBac = 0.0;
                }

                String s = String.format("%.2f%%", actualBac);

                resultTxt.setText(s);
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        getSupportActionBar().hide();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

}
