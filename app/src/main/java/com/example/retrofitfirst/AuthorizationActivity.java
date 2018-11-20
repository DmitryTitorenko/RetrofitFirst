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

        MainLogic.getInstance().userLogInStart(name, password,  this);



    }

    public void toRegistrationUser(View view) {
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void startListDino(){
        if (UserLogic.isLogIn.equals("Yep")) {
            Intent intent = new Intent(this, ViewDinosActivity.class);
            startActivity(intent);

        } else {
            Context context = getApplicationContext();
            CharSequence text = "Not correct login or password";
            Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
