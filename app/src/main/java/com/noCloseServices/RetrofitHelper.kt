package com.noCloseServices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private const val PROTOCOL_HEADER = "https://"
    private const val URL_IP = "example.com"
    private const val PORT_SEPERATOR = "/"
    private const val PATH = "Example"
    private const val PORT_SEPERATOR2 = "/"
    private const val BASE_URL = "$PROTOCOL_HEADER$URL_IP$PORT_SEPERATOR$PATH$PORT_SEPERATOR2"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}