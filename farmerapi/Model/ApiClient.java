package com.example.farmerapi.Model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



//Create a retrofit api client and specify the Base url, Retrofit configurations.
public class ApiClient{

    private static final  String BaseUrl = "http://196.43.152.10/COOPERP/Mobile/";
    private  static Retrofit retrofit;
    public  static  Retrofit getApiClient(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return  retrofit;
    }
}




