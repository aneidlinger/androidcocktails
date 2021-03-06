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



public class DirtyMartini extends AppCompatActivity {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dirty_martini);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE
                // Set the content to appear under the system bars so that the
                // content doesn't resize when the system bars hide and show.
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                // Hide the nav bar and status bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);


        spinner = findViewById(R.id.qty_spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.number_servings, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            double vodkaOz;
            double vermOz;
            double oliveOz;

            TextView vodkaOzTxt = findViewById(R.id.vodka_text);
            TextView vermOzTxt = findViewById(R.id.verm_text);
            TextView oliveOzTxt = findViewById(R.id.olive_text);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int qtyServings = Integer.parseInt(spinner.getSelectedItem().toString());
                vodkaOz = 3.5 * qtyServings;
                String vodkaResult = String.format("%.2f" + " oz. Vodka", vodkaOz);
                vodkaOzTxt.setText(vodkaResult);

                vermOz = .25 * qtyServings;
                String vermResult = String.format("%.2f" +  " oz. Vermouth", vermOz);
                vermOzTxt.setText(vermResult);

                oliveOz = .5 * qtyServings;
                String oliveResult = String.format("%.2f" + " oz. Olive Juice", oliveOz);
                oliveOzTxt.setText(oliveResult);
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
