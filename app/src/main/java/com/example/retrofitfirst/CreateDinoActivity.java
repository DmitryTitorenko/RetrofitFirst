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
import com.example.retrofitfirst.entity.dino.create.Und;
import com.example.retrofitfirst.entity.dino.create.Und_;
import com.example.retrofitfirst.entity.dino.create.Und__;
import com.example.retrofitfirst.entity.dino.create.Und___;
import com.example.retrofitfirst.entity.dino.create.Value;
import com.example.retrofitfirst.logic.MainLogic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry Titorenko on 15.11.2018.
 */
public class CreateDinoActivity extends AppCompatActivity {

    private String title;
    private String status;
    private String name;
    private String type;
    private FieldDinoColor fieldDinoColor;
    private FieldDinoAbout fieldDinoAbout;
    private FieldDinoBirthDate fieldDinoBirthDate;
    private FieldDitoImage fieldDitoImage;

    EditText etTitle;
    EditText etName;
    EditText etColor;
    EditText etAbout;
    EditText etDayBirthDate;
    EditText etMonthBirthDate;
    EditText etYerBirthDate;

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
        title = etTitle.getText().toString();
        status = "1";
        name = etName.getText().toString();
        type = "dino";

        // set color
        fieldDinoColor = new FieldDinoColor();
        Und und = new Und();
        und.setTid(etColor.getText().toString());
        fieldDinoColor.setUnd(und);


        //set About
        fieldDinoAbout = new FieldDinoAbout();
        Und_ und_ = new Und_();
        und_.setValue(etAbout.getText().toString());
        List<Und_> und_list = new ArrayList<>();
        und_list.add(und_);
        fieldDinoAbout.setUnd(und_list);


        //set BirthDate
        fieldDinoBirthDate = new FieldDinoBirthDate();

        Value value = new Value();
        value.setDay(etDayBirthDate.getText().toString());
        value.setMonth(etMonthBirthDate.getText().toString());
        value.setYear(etYerBirthDate.getText().toString());
        value.setHour("00");
        value.setMinute("00");
        value.setSecond("00");

        Und__ und__ = new Und__();
        und__.setValue(value);

        List<Und__> und__list = new ArrayList<>();
        und__list.add(und__);

        fieldDinoBirthDate.setUnd(und__list);

        // set Image
        fieldDitoImage = new FieldDitoImage();

        Und___ und___ = new Und___();
        und___.setFid(MainLogic.getInstance().getImageFID());

        List<Und___> und___list = new ArrayList<>();
        und___list.add(und___);

        fieldDitoImage.setUnd(und___list);

        MainLogic.getInstance().sendDino(title, status, name, type, fieldDinoColor, fieldDinoAbout, fieldDinoBirthDate, fieldDitoImage);
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


    public String getMimeType(Uri uri) {
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

    public String getFileName(Uri uri) {
        String result;

        //if uri is content
        if (uri.getScheme() != null && uri.getScheme().equals("content")) {
            Cursor cursor = this.getApplicationContext().getContentResolver().query(uri, null, null, null, null);
            try {
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
            } finally {
                cursor.close();
            }
        }

        result = uri.getPath();

        //get filename + ext of path
        int cut = result.lastIndexOf('/');
        if (cut != -1)
            result = result.substring(cut + 1);
        return result;
    }
}

