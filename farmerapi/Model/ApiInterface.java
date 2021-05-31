package com.example.farmerapi.Model;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
/**
Api interface with the post parameters include key values.

In the interface we can declare post an get methods to fetch or insert data using json api links.

Also we configure the methods using a model class so that the data is parsed through them and we can use the data directly in our code.

In this example we have used POST parameter to which we have sent image name as title and image path to the respective fields.
**/

public interface ApiInterface {
    @FormUrlEncoded
    @POST("Default.aspx")
    Call<Img_Pojo> uploadImage(@Field("DataFormat") String DataFormat, //image
                               @Field("FName") String FName,
                               @Field("SName") String SName,
                               @Field("Sex") String Sex,
                               @Field("DOB") String DOB,
                               @Field("maritalS") String maritalS,
                               @Field("Feduc") String Feduc,
                               @Field("district") String district,
                               @Field("county") String county,
                               @Field("subcounty") String subCounty,
                               @Field("village") String village,
                               @Field("group") String group,
                               @Field("comment") String comment,
                               @Field("enteredby") String enteredby,
                               @Field("photo") String photo,
                               @Field("phone") String phone);

    }

