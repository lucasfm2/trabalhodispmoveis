package com.ucsal.trabalhodispmoveis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.teepstech.sqlitecrud.R;

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

        final TextView textview = findViewById(R.id.textview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://fakerapi.it/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FakerApiService service = retrofit.create(FakerApiService.class);

        Call<Book>call=service.getBook();
        call.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {
               if (!response.isSuccessful()) {
                   textview.setText(response.code());
                   return;
               }
                textview.setText(response.code());
            }

            @Override
            public void onFailure(Call<Book> call, Throwable throwable) {
            textview.setText(throwable.getMessage());
            }
        });
    }
}