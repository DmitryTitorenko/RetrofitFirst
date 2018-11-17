package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.retrofitfirst.logic.MainLogic;
import com.example.retrofitfirst.logic.UserLogic;

/**
 * Created by Dmitry Titorenko on 16.11.2018.
 */
public class AuthorizationActivity extends AppCompatActivity {
    private String name;
    private String password;

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
        name = etName.getText().toString();
        password = etPassword.getText().toString();

        MainLogic.getInstance().start();

        MainLogic.getInstance().userLogInStart(name, password);

        if (UserLogic.isLogIn = true) {
            Intent intent = new Intent(this, ViewDinosActivity.class);
            startActivity(intent);

        } else {
            // create activity for not correct password
        }

    }

    public void toRegistrationUser(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }
}
