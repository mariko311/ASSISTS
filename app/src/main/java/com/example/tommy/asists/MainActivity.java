package com.example.tommy.asists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onClickButtonListener();
    }

    private void onClickButtonListener() {
        Button btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener (this);
    }

    @Override
    public void onClick(View v) {
        Intent intentCategory = new Intent(this,CategoryActivity.class);
        startActivity(intentCategory);
    }
}
