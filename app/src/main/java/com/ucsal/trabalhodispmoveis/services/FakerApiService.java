package com.ucsal.trabalhodispmoveis.services;

import com.ucsal.trabalhodispmoveis.models.ResponseValue;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakerApiService {

    @GET ("books?_quantity=1")
    Call<ResponseValue> getBook();


}
