package com.example.tommy.asists;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
/**
 * Created by Marios on 9/14/2016.
 */

public class splash extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    Intent startfirstview = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(startfirstview);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}