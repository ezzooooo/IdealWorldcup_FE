package com.yjy.idw.api

import com.yjy.idw.data.ResultVO
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ResultAPI {
    @Headers("Accept:application/json")
    @POST("results")
    fun insertResult(@Body vo: ResultVO)
}