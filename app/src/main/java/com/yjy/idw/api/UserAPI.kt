package com.yjy.idw.api

import com.yjy.idw.data.UserVO
import retrofit2.Call
import retrofit2.http.*

interface UserAPI {
    /* GET USER INFORMATION */
    @GET("users")
    fun getUserList() : Call<List<UserVO>>

    @GET("users/{id}")
    fun getUser(@Path("id")id: Int) : Call<UserVO>

    @POST("/users")
    fun insertUser(@Body vo: UserVO)

    @DELETE("/users/{id}")
    fun deleteUser(@Path("id")id: Int)
}