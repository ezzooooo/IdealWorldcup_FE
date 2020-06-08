package com.yjy.idw.data

data class TournamentVO(
    private var id : Int,
    private var user_id : Int,
    private var title : String,
    private var intro : String,
    private var category : String,
    private var isPrivate : Int,
    private var passwd : String,
    private var like_cnt : Int,
    private var play_cnt : Int,
    private var sortBy : String
)