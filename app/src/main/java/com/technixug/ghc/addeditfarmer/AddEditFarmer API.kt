package com.technixug.ghc.addeditfarmer

import android.telecom.Call
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface MyApi {
    @FormUrlEncoded
    @POST("insertdata.php")
    fun insertdata(
            @Field("name") name: String?,
            @Field("email") email: String?
    ): Call//<ResponseBody>?
}