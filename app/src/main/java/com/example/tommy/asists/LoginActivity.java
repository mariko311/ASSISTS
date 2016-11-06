package com.example.tommy.asists;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.util.HashMap;

public class LoginActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener {

    String tipe;
    EditText etUserName, etPassword;
    Button btnSignIn, btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Bundle bundle = getIntent().getExtras();
        tipe = bundle.getString("tipe");
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignUp = (Button) findViewById(R.id.btnSignUp);
        btnSignIn.setOnClickListener(this);
        btnSignUp.setOnClickListener(this);

    }

    @Override
    public void processFinish(String result) {
        if (result.equals("failed")){
            Toast.makeText(this,result,Toast.LENGTH_LONG).show();
        }
        else {
            Bundle bundle = new Bundle();
            bundle.putString("nama", result);
            Intent i = new Intent(this, JobCategoryActivity.class);
            i.putExtras(bundle);
            startActivity(i);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btnSignIn :
                //lakukan login
                HashMap postData = new HashMap();
                postData.put("txtUsername",etUserName.getText().toString());
                postData.put("txtPassword",etPassword.getText().toString());
                postData.put("txtTipe",tipe);
                PostResponseAsyncTask task = new PostResponseAsyncTask(this,postData);
                task.execute("http://assistsid.com/login.php");
                break;
            case R.id.btnSignUp :
                //jalankan halaman register
                Intent intentSignUp = new Intent(this, SignupEmployeerActivity.class);
                startActivity(intentSignUp);
                break;
        }    }
}
