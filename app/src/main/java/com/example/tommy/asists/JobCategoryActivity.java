package com.example.tommy.asists;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JobCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_category);
        Bundle bundle = getIntent().getExtras();
        TextView tvName = (TextView) findViewById(R.id.tvName);
        tvName.setText(bundle.getString("nama"));
    }
}
