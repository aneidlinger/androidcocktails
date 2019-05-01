package com.example.wrl123u.drinkrecipes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.VideoView;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    VideoView vid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        vid = findViewById(R.id.video);

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                finish();
                startActivity(new Intent(Splash.this, Menu.class));
            }
        };

        int id = this.getRawResIdByName("cocktail_prep");
        vid.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + id));
        vid.start();

        Timer opening = new Timer();
        opening.schedule(task, 5000);

    }

    public int getRawResIdByName(String resName) {

        String pkgName = this.getPackageName();
        int resID = this.getResources().getIdentifier(resName, "raw", pkgName);
        Log.i("AndroidVideoView", "Res Name: " + resName + "==>Res ID = " + resID);
        return resID;

    }

}
