package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.retrofitfirst.logic.ControllerDino;

public class RegistrationActivity extends AppCompatActivity {
    private String name;
    private String mail;
    private String password;

    EditText etName;
    EditText etMail;
    EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        etName = findViewById(R.id.etName);
        etMail = findViewById(R.id.etMail);
        etPassword = findViewById(R.id.etPassword);
    }

    public void registrationUser(View view) {
        name = etName.getText().toString();
        mail = etMail.getText().toString();
        password = etPassword.getText().toString();
        ControllerDino controllerDino = new ControllerDino();
        controllerDino.start();
        controllerDino.sendUser(name, mail, password);
    }
}
