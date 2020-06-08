package com.yjy.idw.api

import com.yjy.idw.data.TournamentVO
import retrofit2.Call
import retrofit2.http.*

interface TournamentAPI {
    @Headers("Accept:application/json")
    @GET("tournaments")
    fun getTournamentList(@Query("category") category: String, @Query("title") title: String, @Query("sortBy") sortBy: String ) : Call<List<TournamentVO>>

    @Headers("Accept:application/json")
    @POST("tournaments")
    fun insertTournament(@Body vo: TournamentVO)

    @Headers("Accept:application/json")
    @DELETE("tournaments/{id}")
    fun deleteTournament(@Path("id") id: Int)

    @Headers("Accept:application/json")
    @GET("tournaments/{id}")
    fun getTournament(@Path("id") id: Int) : Call<TournamentVO>

    @Headers("Accept:application/json")
    @PUT("tournaments/playcnt/{id}")
    fun addPlayCnt(@Path("id") id: Int)

    @Headers("Accept:application/json")
    @PUT("tournaments/likecnt/{id}")
    fun addLikeCnt(@Path("id") id: Int)

    @Headers("Accept:application/json")
    @PUT("tournaments/unlikecnt/{id}")
    fun removeLikeCnt(@Path("id") id: Int)
}