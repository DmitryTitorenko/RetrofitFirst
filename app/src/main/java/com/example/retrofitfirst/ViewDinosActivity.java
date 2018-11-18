package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.retrofitfirst.entity.dino.DinoWrapper;
import com.example.retrofitfirst.logic.MainLogic;


public class ViewDinosActivity extends AppCompatActivity {

    private RecyclerView rvDinos;
    private Button btAddDinos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dinos);

        btAddDinos = findViewById(R.id.btAddDinos);

        // Lookup the recyclerview in activity layout
        rvDinos = findViewById(R.id.rvDinos);
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
}
