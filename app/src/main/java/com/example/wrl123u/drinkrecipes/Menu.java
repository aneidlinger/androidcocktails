package com.example.wrl123u.drinkrecipes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.View.OnClickListener;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class Menu extends AppCompatActivity {

    String[] drinkName = {"Dirty Martini", "Old Fashioned", "Manhattan", "Margarita"};
    int[] image = {R.mipmap.dirty_martini, R.mipmap.old_fashioned, R.mipmap.manhattan, R.mipmap.margarita};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        List<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < drinkName.length; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("drink_name", drinkName[i]);
            hm.put("drink_image", Integer.toString(image[i]));
            mylist.add(hm);
        }

        String[] from = {"drink_name", "drink_image"};
        int[] to = {R.id.name, R.id.pic};

        SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), mylist, R.layout.list_items, from, to);
        ListView androidListView = findViewById(R.id.listFrame);
        androidListView.setAdapter(simpleAdapter);

        androidListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch(position) {
                    case 0:
                        startActivity(new Intent(Menu.this, DirtyMartini.class));
                        break;
                    case 1:
                        startActivity(new Intent(Menu.this, OldFashioned.class));
                        break;
                    case 2:
                        startActivity(new Intent(Menu.this, Manhattan.class));
                        break;
                    case 3:
                        startActivity(new Intent(Menu.this, Margarita.class));
                        break;
                }

            }
        });

        TextView button = findViewById(R.id.to_estimator);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startActivity(new Intent(Menu.this, Estimator.class));
            }
        });



    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }


}
