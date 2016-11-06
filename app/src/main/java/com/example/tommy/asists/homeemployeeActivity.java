package com.example.tommy.asists;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class homeemployeeActivity extends Activity {
    GridView grid;
    String[] web = {
            "ADMIN",
            "FINANCE / BANKING",

    } ;
    int[] imageId = {
            R.drawable.admin,
            R.drawable.fin_acct,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_employee);

        SingleGridActivity adapter = new SingleGridActivity(homeemployeeActivity.this, web, imageId);
        grid=(GridView)findViewById(R.id.gridView);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(homeemployeeActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });

    }

}