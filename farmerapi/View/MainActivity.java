package com.example.farmerapi.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.farmerapi.Model.ApiClient;
import com.example.farmerapi.Model.ApiInterface;
import com.example.farmerapi.Model.Img_Pojo;
import com.example.farmerapi.R;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    Button  upload, choose;
    EditText dataFormat, fName, sName, sex, dob, maritalS, feduc, district, county, subcounty, village, group, comment, enteredby, phone;
    ImageView photo;
    DatePickerDialog picker;
    private static final int CAPTURE_REQUET = 123;
    public static Bitmap bitmap;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        choose = findViewById(R.id.buPhoto);
        upload = findViewById(R.id.buUploadDrf);


        upload = findViewById(R.id.buUploadDrf);
        dataFormat = findViewById(R.id.etdataFormat);
        fName = findViewById(R.id.etfName);
        sName  = findViewById(R.id.etsName);
        sex = findViewById(R.id.etsex);
        dob = findViewById(R.id.etdob);
        maritalS = findViewById(R.id.etmaritalS);
        feduc = findViewById(R.id.etfeduc);
        district = findViewById(R.id.etdistrict);
        county = findViewById(R.id.etcounty);
        subcounty = findViewById(R.id.etsubcounty);
        village = findViewById(R.id.etvillage);
        group = findViewById(R.id.etgroup);
        comment = findViewById(R.id.etcomment);
        enteredby = findViewById(R.id.etenteredby);
        photo = findViewById(R.id.imgView);
        phone = findViewById(R.id.etphone);


        //get Date
        dob.setInputType(InputType.TYPE_NULL);

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dob.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                            }
                        }, year, month, day);
                picker.show();
            }
        });



        //choose image
        choose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });



        //upload image
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImage();
            }
        });


    }



    //select image
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, CAPTURE_REQUET);
    }

    //Convert the selected image we are using JPEG compress format with maintaining a 100 % compress rate
// but in real time it may reduce to attain storage constraints
    private String convertToString() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imgByte = byteArrayOutputStream.toByteArray();
        return Base64.encodeToString(imgByte, Base64.DEFAULT);
    }


    //After selecting image bind it to image view using onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAPTURE_REQUET && resultCode == RESULT_OK && data != null) {
            Uri path = data.getData();

            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), path);
                photo.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    //finally upload the image and fetch the response
    private void uploadImage(){

        String Photo = convertToString();

        String DataFormat = dataFormat.getText().toString();
        String FName = fName.getText().toString();
        String SName = sName.getText().toString();
        String Sex = sex.getText().toString();
        String DOB = dob.getText().toString();
        String MaritalS = maritalS.getText().toString();
        String Feduc = feduc.getText().toString();
        String District = district.getText().toString();
        String County = county.getText().toString();
        String SubCounty = subcounty.getText().toString();
        String Village = village.getText().toString();
        String Group = group.getText().toString();
        String Comment = comment.getText().toString();
        String Enteredby = enteredby.getText().toString();
        String Phone = phone.getText().toString();


        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Img_Pojo> call = apiInterface.uploadImage(DataFormat, FName, SName, Sex, DOB, MaritalS, Feduc, District, County, SubCounty, Village, Group, Comment, Enteredby, Photo, Phone);

        call.enqueue(new Callback<Img_Pojo>() {
            @Override
            public void onResponse(Call<Img_Pojo> call, Response<Img_Pojo> response) {

                Img_Pojo img_pojo = response.body();
                Log.d("Server Response",""+img_pojo.getResponse());
                Toast.makeText(getApplicationContext(), img_pojo.getResponse(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void onFailure(Call<Img_Pojo> call, Throwable t) {
                Log.d("Server Response",""+t.toString());
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

            }
        });

    }

}


