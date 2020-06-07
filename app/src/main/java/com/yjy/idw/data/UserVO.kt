package com.yjy.idw.data

import com.google.gson.annotations.SerializedName

data class UserVO(
    @SerializedName("id")
    var id : Int,
    @SerializedName("nickname")
    var nickname : String
)