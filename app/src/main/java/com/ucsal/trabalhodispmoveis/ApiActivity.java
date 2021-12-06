package com.ucsal.trabalhodispmoveis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ucsal.trabalhodispmoveis.models.ResponseValue;
import com.ucsal.trabalhodispmoveis.services.FakerApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);

        TextView textview = findViewById(R.id.textview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakerapi.it/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FakerApiService service = retrofit.create(FakerApiService.class);

        Call<ResponseValue> call=service.getBook();
        call.enqueue(new Callback<ResponseValue>() {


            @Override
            public void onResponse(Call<ResponseValue> call, Response<ResponseValue> response) {
                if (response.isSuccessful()) {
                    ResponseValue responseValue = response.body();
                    textview.setText(responseValue.getBooks().toString());
                }

            }

            @Override
            public void onFailure(Call<ResponseValue> call, Throwable throwable) {
                textview.setText(throwable.getMessage().toString());
            }
        });
    }
}