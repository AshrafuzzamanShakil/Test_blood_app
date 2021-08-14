package com.shakil.test_blod.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.shakil.test_blod.R;
import com.shakil.test_blod.Retrofit.ApiInterface;
import com.shakil.test_blod.Retrofit.PostPojo;

import retrofit2.Call;

public class Post_activity extends AppCompatActivity {

    Spinner spinner;
    Button post;
    EditText discription,location,hospital;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_activity);

        spinner=findViewById(R.id.spiner_id);
        post=findViewById(R.id.post_id);
        discription=findViewById(R.id.edit_text_discription_id);
        location=findViewById(R.id.edit_text_location_id);
        hospital=findViewById(R.id.edit_text_hospital_id);

        ArrayAdapter<CharSequence> adapterBlood=ArrayAdapter.createFromResource(this,R.array.Blood_Group,R.layout.spiner_layout);
        adapterBlood.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapterBlood);

        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                PostPojo postPojo=new PostPojo("6","Shakil",location.getText().toString(),"01798915935",
                        spinner.getSelectedItem().toString(),discription.getText().toString(),
                        hospital.getText().toString(),"shakil");

                Call<PostPojo> call=apiInterface.creat_post(postPojo);
                Toast.makeText(Post_activity.this,"Success",Toast.LENGTH_LONG).show();



            }
        });


    }
}