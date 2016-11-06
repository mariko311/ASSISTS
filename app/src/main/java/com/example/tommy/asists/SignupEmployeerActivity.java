package com.example.tommy.asists;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class SignupEmployeerActivity extends AppCompatActivity implements AsyncResponse, View.OnClickListener {
    private Spinner spinnerTitle, spinnerGender;
    ArrayAdapter<String> adapterTitle;
    ArrayAdapter<String> adapterGender;

    EditText etContactPerson, etName, etPassword, etBirthDate, etTelephone, etEmail,
        etConfirmPassword, etBirthPlace;
    String title, gender;
    Button btnRegister, btnBirthDate;
    List<String> spinnerData = new ArrayList<>();
    List<String> spinnerDataGender = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_employeer);
        gender = "Pria";
        title = "Lainnya";
        spinnerTitle = (Spinner) findViewById(R.id.spnTitle);
        spinnerTitle = new Spinner(this);
        String [] arrData = getResources().getStringArray(R.array.title);
        spinnerData = Arrays.asList(arrData);
        adapterTitle = new ArrayAdapter <String>(this,android.R.layout.simple_spinner_item,spinnerData);
        adapterTitle.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTitle.setAdapter(adapterTitle);
        spinnerTitle.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                title = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerGender = (Spinner) findViewById(R.id.spnGender);
        spinnerGender = new Spinner(this);
        String[] arrDataGender = getResources().getStringArray(R.array.gender);
        spinnerDataGender = Arrays.asList(arrDataGender);
        adapterGender = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerDataGender);
        adapterGender.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapterGender);
        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                gender = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final Calendar c = Calendar.getInstance();
        final int year = c.get(Calendar.YEAR);
        final int month = c.get(Calendar.MONTH);
        final int day = c.get(Calendar.DAY_OF_MONTH);
        etContactPerson = (EditText) findViewById(R.id.etContactPerson);
        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);
        etBirthDate = (EditText) findViewById(R.id.etBirthDate);
        etTelephone = (EditText) findViewById(R.id.etTelephone);
        etBirthPlace = (EditText) findViewById(R.id.etBirthPlace);

        btnBirthDate = (Button) findViewById(R.id.btnBirthDate);
        btnBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        btnBirthDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datepick = new DatePickerDialog(SignupEmployeerActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String tanggal;
                        tanggal = dayOfMonth + "/" + (monthOfYear+1) + "/" + year;
                        etBirthDate.setText(tanggal);
                    }
                },year, month, day);
                datepick.setTitle("Pilih Tanggal");
                datepick.show();
            }
        });

        btnRegister = (Button) findViewById(R.id.btnSignUp);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
//        Toast.makeText(this,etContactPerson.getText().toString() + etBirthDate.getText().toString() + gender + title,Toast.LENGTH_LONG).show();
        HashMap postData = new HashMap();
        postData.put("txtContactPerson",etContactPerson.getText().toString());
        postData.put("txtName",etName.getText().toString());
        postData.put("txtEmail",etEmail.getText().toString());
        postData.put("txtPassword",etPassword.getText().toString());
        postData.put("txtConfirmPassword",etConfirmPassword.getText().toString());
        postData.put("txtBirthDate",etBirthDate.getText().toString());
        postData.put("txtTelephone",etTelephone.getText().toString());
        postData.put("txtGender",gender);
        postData.put("txtTitle",title);
        postData.put("txtBirthPlace",etBirthPlace.getText().toString());
        PostResponseAsyncTask task = new PostResponseAsyncTask(this,postData);
//        task.execute("http://192.168.100.13:8080/client/employeersignup.php");
        task.execute("http://assistsid.com/employeersignup.php");
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
}
