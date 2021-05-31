package com.example.farmerapi.Model;
import com.google.gson.annotations.SerializedName;

/**
Api interface with the post parameters include key values.

In the interface we can declare post an get methods to fetch or insert data using json api links.

Also we configure the methods using a model class so that the data is parsed through them and we can use the data directly in our code.

In this example we have used POST parameter to which we have sent image name as title and image path to the respective fields.
**/


public class Img_Pojo {

    @SerializedName("DataFormat")
    private String DataFormat;

    @SerializedName("FName")
    private String FirstName;

    @SerializedName("SName")
    private String SurName;

    @SerializedName("Sex")
    private String Sex;

    @SerializedName("DOB")
    private String DOB;

    @SerializedName("maritalS")
    private String MaritalStatus;

    @SerializedName("Feduc")
    private String Feduc;

    @SerializedName("district")
    private String District;

    @SerializedName("county")
    private String County;

     @SerializedName("subcounty")
    private String SubCounty;

    @SerializedName("village")
    private String Village;

    @SerializedName("group")
    private String Group;

    @SerializedName("comment")
    private String Comment;

    @SerializedName("enteredby")
    private String EnteredBy;

    @SerializedName("photo")
    private String Photo;

    @SerializedName("phone")
    private String Phone;


    ///////////////////

    @SerializedName("response")
    private String Response;

    public String getResponse() {
        return Response;
    }
}
