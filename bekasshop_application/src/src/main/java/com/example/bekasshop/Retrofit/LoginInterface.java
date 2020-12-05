package com.example.bekasshop.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {
    String LOGINURL = "http://192.168.1.5/bekasshopAPI/";
    @FormUrlEncoded
    @POST("simplelogin.php")
    Call<String> getUserLogin(
            @Field("username") String uname,
            @Field("password") String password
    );
}
