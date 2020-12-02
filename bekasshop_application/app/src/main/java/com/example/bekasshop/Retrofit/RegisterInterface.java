package com.example.bekasshop.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterInterface {
    String REGIURL = "http://192.168.1.5/bekasshopAPI/";
    @FormUrlEncoded
    @POST("simpleregister.php")
    Call<String> getUserRegi(
            @Field("emails") String email,
            @Field("username") String uname,
            @Field("password") String password
    );
}
