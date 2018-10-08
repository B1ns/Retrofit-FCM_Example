package com.example.test1002;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("http://api.hansei.us/")
    Call<TestRepo> ApiService();
}
