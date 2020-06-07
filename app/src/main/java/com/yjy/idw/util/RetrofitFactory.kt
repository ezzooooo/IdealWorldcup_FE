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
                    .baseUrl("URL 입력할 것")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
    }
}