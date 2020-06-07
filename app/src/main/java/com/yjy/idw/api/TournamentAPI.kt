package com.yjy.idw.api

import com.yjy.idw.data.TournamentVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface TournamentAPI {

    @Headers("Accept:application/json")
    @GET("tournaments")
    fun getTournamentList(@Query("category") category: String, @Query("title") title: String, @Query("sortBy") sortBy: String ) : Call<List<TournamentVO>>


}