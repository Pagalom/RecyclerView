package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ListAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    static final String BASE_URL = "https://api.deezer.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showList();
        makeAPICall();
    }

    private void showList() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        //use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        List<String> input = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            input.add("Test" + i);
        }
        // define an adapter
        mAdapter = new ListAdapter(input);
        recyclerView.setAdapter(mAdapter);
    }

    private void makeAPICall(){
        Gson gson = new
                GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        DeezerAPI deezerAPI = retrofit.create(DeezerAPI.class);

        Call<RestDeezerResponse> call;
        call = deezerAPI.getDeezerResponse();
        call.enqueue(new Callback<RestDeezerResponse>() {
            @Override
            public void onResponse(Call<RestDeezerResponse> call, Response<RestDeezerResponse> response) {
                if(response.isSuccessful() && response.body().getResult()!=null){
                    ArrayList<PlaylistDeezer> PlaylistList = response.body().getResult();
                    Toast.makeText(getApplicationContext(), "API success", Toast.LENGTH_SHORT).show();
                }
                else {
                    Log.i("MyLog", "Error in callback : onFailure2"+response.body().getResult());
                    showError();
                }
            }

            @Override
            public void onFailure(Call<RestDeezerResponse> call, Throwable t) {
                showError();
                Log.i("MyLog", "Error in callback : onFailure"+t.getMessage());
            }
        });

    }

    private void showError() {
        Toast.makeText(getApplicationContext(), "API error", Toast.LENGTH_SHORT).show();
    }
}