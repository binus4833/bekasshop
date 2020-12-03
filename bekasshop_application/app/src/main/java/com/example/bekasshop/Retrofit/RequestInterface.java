package com.example.bekasshop.Retrofit;

import com.example.bekasshop.Model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("productshow.php")
    Call<JSONResponse> getJSON();
}
