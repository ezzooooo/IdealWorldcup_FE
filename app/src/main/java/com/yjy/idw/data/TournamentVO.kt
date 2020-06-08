package com.yjy.idw.data

import com.google.gson.annotations.SerializedName

data class TournamentVO(
    @SerializedName("id")
    private var id : Int,
    @SerializedName("user_id")
    private var user_id : Int,
    @SerializedName("title")
    private var title : String,
    @SerializedName("intro")
    private var intro : String,
    @SerializedName("category")
    private var category : String,
    @SerializedName("isPrivate")
    private var isPrivate : Int,
    @SerializedName("passwd")
    private var passwd : String,
    @SerializedName("like_cnt")
    private var like_cnt : Int,
    @SerializedName("play_cnt")
    private var play_cnt : Int,
    @SerializedName("sortBy")
    private var sortBy : String
)