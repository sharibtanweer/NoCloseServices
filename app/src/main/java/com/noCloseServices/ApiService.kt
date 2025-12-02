package com.noCloseServices

import retrofit2.http.POST

interface ApiService {

    @POST("ping_me.php")
    suspend fun getPing(): PingResponse

}