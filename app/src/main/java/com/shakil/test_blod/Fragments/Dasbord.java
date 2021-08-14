package com.shakil.test_blod.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.shakil.test_blod.Adapter.RecycleAdapter;
import com.shakil.test_blod.Activities.Post_activity;
import com.shakil.test_blod.R;
import com.shakil.test_blod.Retrofit.ApiInterface;
import com.shakil.test_blod.Retrofit.PostPojo;
import com.shakil.test_blod.Retrofit.RetrofiteInstence;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Dasbord extends Fragment {


    ApiInterface apiInterface;
    RecyclerView recyclerView;
    TextView how_many_people;
    //Button see_button;
    EditText editText;
    Button post_button_id;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return  inflater.inflate(R.layout.fragment_dasbord, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView=view.findViewById(R.id.RecycleviewId);
        how_many_people=view.findViewById(R.id.how_many_people_id);
        editText=view.findViewById(R.id.edit_text_1id);
        post_button_id=view.findViewById(R.id.post_button_id);
        post_button_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(getActivity(), Post_activity.class);
                startActivity(i);

            }
        });

       // see_button=view.findViewById(R.id.see_id);

        apiInterface= RetrofiteInstence.getRetrofit().create(ApiInterface.class);
        apiInterface.getposts().enqueue(new Callback<List<PostPojo>>() {
            @Override
            public void onResponse(Call<List<PostPojo>> call, Response<List<PostPojo>> response) {
                if (response.body().size() > 0) {
                    List<PostPojo> postPojos = response.body();
                    int i = postPojos.size();
                    how_many_people.setText(i+" people");

                    recyclerView.setAdapter(new RecycleAdapter(getActivity(),postPojos));
                    recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                } else {
                    Toast.makeText(getActivity(), "Error here", Toast.LENGTH_LONG).show();
                }


            }


            @Override
            public void onFailure(Call<List<PostPojo>> call, Throwable t) {
                Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });










    }
}