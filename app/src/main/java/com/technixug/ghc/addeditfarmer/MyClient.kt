package com.technixug.ghc.addeditfarmer

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MyClient private constructor() {


    private val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
    val myApi: MyApi
        get() = retrofit.create(MyApi::class.java)

    companion object {
        private const val BASE_URL = "http://196.43.152.10/COOPERP/Mobile/Default.aspx?/"

        private var myClient: MyClient? = null

        @get:Synchronized
        val instance: MyClient?
            get() {
                if (myClient == null) {
                    myClient = MyClient()
                }
                return myClient
            }
    }

}