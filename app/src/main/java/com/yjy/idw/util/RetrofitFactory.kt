package com.yjy.idw.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
    companion object {
        private var retrofit : Retrofit? = null

        fun getRetrofit() : Retrofit =
            retrofit ?: synchronized(this) {
                Retrofit
                    .Builder()
                    .baseUrl("http://15.164.56.5:8080/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
    }
}