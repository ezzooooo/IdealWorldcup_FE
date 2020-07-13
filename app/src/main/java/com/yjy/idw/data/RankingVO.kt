package com.yjy.idw.data

import com.google.gson.annotations.SerializedName

data class RankingVO(
    @SerializedName("image_url")
    var image_url: String,
    @SerializedName("rank_num")
    var rank_num: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("trophy_rate")
    var trophy_rate: String,
    @SerializedName("win_rate")
    var win_rate: String
)