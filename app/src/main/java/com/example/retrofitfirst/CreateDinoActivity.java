package com.example.retrofitfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;


import com.example.retrofitfirst.entity.dino.create.FieldDinoAbout;
import com.example.retrofitfirst.entity.dino.create.FieldDinoBirthDate;
import com.example.retrofitfirst.entity.dino.create.FieldDinoColor;
import com.example.retrofitfirst.entity.dino.create.FieldDitoImage;
import com.example.retrofitfirst.entity.dino.create.UndDinoColor;
import com.example.retrofitfirst.entity.dino.create.UndValueAbout;
import com.example.retrofitfirst.entity.dino.create.UndBirthDateValue;
import com.example.retrofitfirst.entity.dino.create.UndImage;
import com.example.retrofitfirst.entity.dino.create.Value;
import com.example.retrofitfirst.logic.MainLogic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class CreateDinoActivity extends AppCompatActivity {

    private EditText etTitle;
    private EditText etName;
    private EditText etColor;
    private EditText etAbout;
    private EditText etDayBirthDate;
    private EditText etMonthBirthDate;
    private EditText etYerBirthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dino);

        etTitle = findViewById(R.id.etTitle);
        etName = findViewById(R.id.etName);
        etColor = findViewById(R.id.etFieldColor);
        etAbout = findViewById(R.id.etFieldDinoAbout);
        etDayBirthDate = findViewById(R.id.etDay);
        etMonthBirthDate = findViewById(R.id.etMonth);
        etYerBirthDate = findViewById(R.id.etYear);

        Button btn_upload = findViewById(R.id.btn_upload);
        btn_upload.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 0);
        });
    }

    public void createDino(View view) {
        String title = etTitle.getText().toString();
        String status = "1";
        String name = etName.getText().toString();
        String type = "dino";

        // set color
        FieldDinoColor fieldDinoColor = new FieldDinoColor();
        UndDinoColor undDinoColor = new UndDinoColor();
        undDinoColor.setTid(etColor.getText().toString());
        fieldDinoColor.setUndDinoColor(undDinoColor);


        //set About
        FieldDinoAbout fieldDinoAbout = new FieldDinoAbout();
        UndValueAbout undValueAbout = new UndValueAbout();
        undValueAbout.setValue(etAbout.getText().toString());

        List<UndValueAbout> undValueAboutList = new ArrayList<>();
        undValueAboutList.add(undValueAbout);
        fieldDinoAbout.setUnd(undValueAboutList);


        //set BirthDate
        FieldDinoBirthDate fieldDinoBirthDate = new FieldDinoBirthDate();

        Value value = new Value();
        value.setDay(etDayBirthDate.getText().toString());
        value.setMonth(etMonthBirthDate.getText().toString());
        value.setYear(etYerBirthDate.getText().toString());
        value.setHour("00");
        value.setMinute("00");
        value.setSecond("00");

        UndBirthDateValue undBirthDateValue = new UndBirthDateValue();
        undBirthDateValue.setValue(value);

        List<UndBirthDateValue> undBirthDateValueList = new ArrayList<>();
        undBirthDateValueList.add(undBirthDateValue);

        fieldDinoBirthDate.setUnd(undBirthDateValueList);

        // set Image
        FieldDitoImage fieldDitoImage = new FieldDitoImage();

        UndImage undImage = new UndImage();
        undImage.setFid(MainLogic.getInstance().getImageFID());

        List<UndImage> undImageList = new ArrayList<>();
        undImageList.add(undImage);

        fieldDitoImage.setUnd(undImageList);

        MainLogic.getInstance().sendDino(title, status, name, type, fieldDinoColor, fieldDinoAbout, fieldDinoBirthDate, fieldDitoImage, this);
    }


    //get image from media and send it to MainLogic.class
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (data != null && requestCode == 0) {

            if (resultCode == RESULT_OK) {
                Uri targetUri = data.getData();
                Bitmap bitmap;
                try {
                    bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));

                    // get mimeType
                    String filemime = getMimeType(targetUri);

                    // get fileName
                    String fileName;
                    fileName = getFileName(targetUri);

                    // start logic
                    MainLogic.getInstance().start();


                    MainLogic.getInstance().sendImage(bitmap, filemime, fileName);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private String getMimeType(Uri uri) {
        String mimeType = null;
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            ContentResolver cr = this.getApplicationContext().getContentResolver();
            mimeType = cr.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri
                    .toString());
            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase());
        }
        return mimeType;
    }

    private String getFileName(Uri uri) {
        String result;

        //if uri is content
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            try (Cursor cursor = this.getApplicationContext().getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    //local filesystem
                    int index = cursor.getColumnIndex("_data");
                    if (index == -1)
                        //google drive
                        index = cursor.getColumnIndex("_display_name");
                    result = cursor.getString(index);
                    if (result != null)
                        uri = Uri.parse(result);
                    else
                        return null;
                }
            }
        }

        result = uri.getPath();

        //get filename + ext of path
        int cut = result.lastIndexOf('/');
        if (cut != -1)
            result = result.substring(cut + 1);
        return result;
    }

    /*
     When create dino successful, return to dino list
     */
    public void returnToListDino() {
        Intent intent = new Intent(this, ViewDinosActivity.class);
        startActivity(intent);
    }
}

