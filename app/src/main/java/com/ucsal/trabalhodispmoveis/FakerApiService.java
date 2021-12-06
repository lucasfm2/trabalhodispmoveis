package com.ucsal.trabalhodispmoveis;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FakerApiService {

    @GET ("books?_quantity=1")
    Call<Book> getBook();


}
