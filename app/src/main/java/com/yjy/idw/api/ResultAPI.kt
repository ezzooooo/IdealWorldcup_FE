package com.yjy.idw.api

import com.yjy.idw.data.ResultVO
import retrofit2.Call
import retrofit2.http.*

interface ResultAPI {
    @Headers("Accept:application/json")
    @POST("results")
    fun insertResult(@Body vo: ResultVO)

    @Headers("Accept:application/json")
    @PUT("results")
    fun updateResult(@Body vo: ResultVO)

    @Headers("Accept:application/json")
    @GET("results")
    fun getResult(@Query("first_image_id") first_image_id: Int, @Query("second_image_id") second_image_id: Int) : Call<ResultVO>
}