package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitfirst.entity.dino.get.DinoWrapper;
import com.example.retrofitfirst.logic.MainLogic;


public class ViewDinosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dinos);


        // Lookup the recyclerview in activity layout
        RecyclerView rvDinos = findViewById(R.id.rvDinos);
        rvDinos.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(ViewDinosActivity.this);
        rvDinos.setLayoutManager(layoutManager);

        // Create adapter passing in the sample user data
        // in first iteration we just set empty dinoWrapper - new DinoWrapper()
        ViewDinoAdapter viewDinoAdapter = new ViewDinoAdapter(new DinoWrapper());

        // Attach the adapter to the recyclerview to populate items
        rvDinos.setAdapter(viewDinoAdapter);

        // update dinoWrapper in viewDinoAdapter and notify about it in rvDinos use rvDinos.notifyDataSetChanged()
        MainLogic.getInstance().getDinos(viewDinoAdapter, rvDinos);
    }

    /*
    Start intent to CreateDinoActivity for create dino
     */
    public void createDino(View view) {
        Intent intent = new Intent(this, CreateDinoActivity.class);
        startActivity(intent);
    }
}
