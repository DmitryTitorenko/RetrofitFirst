package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitfirst.logic.MainLogic;
import com.example.retrofitfirst.logic.UserLogic;

/**
 * Created by Dmitry Titorenko on 16.11.2018.
 */
public class AuthorizationActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
    }

    public void loginUser(View view) {
        String name = etName.getText().toString();
        String password = etPassword.getText().toString();

        MainLogic.getInstance().start();

        MainLogic.getInstance().userLogInStart(name, password, this);

    }

    /*
    If user is new -> he press registration button
     */
    public void toRegistrationUser(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    /*
    Create  ViewDinosActivity
    */
    public void startListDino() {
        Intent intent = new Intent(this, ViewDinosActivity.class);
        startActivity(intent);
    }
}

