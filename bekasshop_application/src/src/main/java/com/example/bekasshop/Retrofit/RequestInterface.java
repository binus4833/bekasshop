package com.example.bekasshop.Retrofit;

import com.example.bekasshop.Model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RequestInterface {

    @GET("productshow.php")
    Call<JSONResponse> getJSON();

    @FormUrlEncoded
    @POST("productshowcategory.php")
    Call<JSONResponse> getJSONCategory(@Field("category") String category);
}
