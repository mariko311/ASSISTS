package com.example.tommy.asists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener {
    ImageButton btnpemberikerja;
    ImageButton btnpencarikerja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        btnpemberikerja = (ImageButton)findViewById(R.id.btnpemberikerja);
        btnpencarikerja = (ImageButton)findViewById(R.id.btnpencarikerja);
        btnpemberikerja.setOnClickListener(this);
        btnpencarikerja.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String gettipe = "-";
        switch (v.getId())
        {
            case R.id.btnpencarikerja:
                //lakukan
                gettipe = "0";
                break;
            case R.id.btnpemberikerja:
                //lakukan
                gettipe = "1";
                break;
        }
        Bundle bundle = new Bundle();
        bundle.putString("tipe", gettipe);
        Intent i = new Intent(this, LoginActivity.class);
        i.putExtras(bundle);
        startActivity(i);
    }
}