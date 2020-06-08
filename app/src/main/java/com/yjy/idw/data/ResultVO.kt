package com.yjy.idw.data

import com.google.gson.annotations.SerializedName

data class ResultVO(
    @SerializedName("id")
    private var id: Int,
    @SerializedName("first_image_id")
    private var first_image_id: Int,
    @SerializedName("second_image_id")
    private var second_image_id: Int,
    @SerializedName("first_win_cnt")
    private var first_win_cnt: Int,
    @SerializedName("second_win_cnt")
    private var second_win_cnt: Int
)