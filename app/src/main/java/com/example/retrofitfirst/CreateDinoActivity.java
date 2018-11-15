package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.Button;

import com.example.retrofitfirst.logic.ControllerDino;

import java.io.FileNotFoundException;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class CreateDinoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dino);

        Button btn_upload = findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 0);
        });
    }

    //get image from media and send it to ControllerDino.class
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data != null && requestCode == 0) {

            if (resultCode == RESULT_OK) {
                Uri targetUri = data.getData();
                Bitmap bitmap;
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));

                    // start logic
                    ControllerDino controllerDino = new ControllerDino();
                    controllerDino.start();
                    controllerDino.sendImage(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

