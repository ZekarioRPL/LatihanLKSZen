package com.example.zendetta.Interface;

import com.example.zendetta.Model.loginModel;
import com.example.zendetta.Model.patientModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface api {
    String BASE_URL = "";

    @POST("patient")
    Call<loginModel> LoginStatus(@Field("handphone") String handphone );

    @GET("patientNew")
    Call<patientModel> getNewPatient();
}
