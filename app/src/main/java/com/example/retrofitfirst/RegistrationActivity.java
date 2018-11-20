package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.retrofitfirst.logic.MainLogic;


/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class RegistrationActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etMail;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.etName);
        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
    }

    /*
    Start get data from UI and start user registration
     */
    public void registrationUser(View view) {
        String name = etName.getText().toString();
        String mail = etMail.getText().toString();
        String password = etPassword.getText().toString();

        MainLogic.getInstance().start();
        MainLogic.getInstance().regUserStart(name, mail, password);
    }
}
