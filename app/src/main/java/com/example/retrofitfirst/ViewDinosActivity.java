package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitfirst.entity.dino.get.DinoWrapper;
import com.example.retrofitfirst.logic.MainLogic;


public class ViewDinosActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeContainer;
    private RecyclerView rvDinos;
    private ViewDinoAdapter viewDinoAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dinos);

        swipeContainer = findViewById(R.id.swiperefresh);


        // Lookup the recyclerview in activity layout
        rvDinos = findViewById(R.id.rvDinos);
        rvDinos.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(ViewDinosActivity.this);
        rvDinos.setLayoutManager(layoutManager);

        // Create adapter passing in the sample user data
        // in first iteration we just set empty dinoWrapper - new DinoWrapper()
        viewDinoAdapter = new ViewDinoAdapter(new DinoWrapper());

        // Attach the adapter to the recyclerview to populate items
        rvDinos.setAdapter(viewDinoAdapter);

        // update dinoWrapper in viewDinoAdapter and notify about it in rvDinos use rvDinos.notifyDataSetChanged()
        MainLogic.getInstance().getDinos(viewDinoAdapter, rvDinos, this);

    }

    /*
    Start intent to CreateDinoActivity for create dino
     */
    public void createDino(View view) {
        Intent intent = new Intent(this, CreateDinoActivity.class);
        startActivity(intent);
    }


    //                    rvDinos.getAdapter().notifyDataSetChanged();


    @Override
    public void onRefresh() {
        rvDinos.setAdapter(null);
        //viewDinoAdapter.clear();
        viewDinoAdapter = new ViewDinoAdapter(new DinoWrapper());
        rvDinos.setAdapter(viewDinoAdapter);

        MainLogic.getInstance().getDinos(viewDinoAdapter, rvDinos, this);
        swipeContainer.setRefreshing(false);
    }
}
