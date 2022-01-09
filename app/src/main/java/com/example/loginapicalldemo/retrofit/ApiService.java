package com.example.loginapicalldemo.retrofit;

import com.example.loginapicalldemo.model.RequestDataClass;
import com.example.loginapicalldemo.model.ResponseDataClass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("smartechs/m675418")
    Call<List<ResponseDataClass>> Login(@Body RequestDataClass requestDataClass);
}


