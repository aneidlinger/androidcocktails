package com.example.wrl123u.drinkrecipes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class OldFashioned extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_old_fashioned);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        spinner = findViewById(R.id.qty_spinner_of);
        adapter = ArrayAdapter.createFromResource(this, R.array.number_servings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            double bourbOz;
            double water;
            double bitters;
            double sugar;

            TextView bourbOzTxt = findViewById(R.id.bourb_text);
            TextView waterTxt = findViewById(R.id.water_text);
            TextView bittersTxt = findViewById(R.id.bitters_text);
            TextView sugarTxt = findViewById(R.id.sugar_text);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int qtyServings = Integer.parseInt(spinner.getSelectedItem().toString());
                bourbOz = 2 * qtyServings;
                String bourbResult = String.format("%.2f" + " oz. Bourbon", bourbOz);
                bourbOzTxt.setText(bourbResult);

                water = 1 * qtyServings;
                String waterResult = String.format("%.2f" +  " tsp. Water", water);
                waterTxt.setText(waterResult);

                bitters = 3 * qtyServings;
                String bittersResult = String.format("%.2f" + " dashes Bitters", bitters);
                bittersTxt.setText(bittersResult);

                sugar = .5 * qtyServings;
                String sugarResult = String.format("%.2f" + " tsp. Sugar", sugar);
                sugarTxt.setText(sugarResult);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
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
