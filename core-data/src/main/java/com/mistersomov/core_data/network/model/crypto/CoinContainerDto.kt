package com.mistersomov.core_data.network.model.crypto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinContainerDto(
    @SerializedName("CoinInfo")
    @Expose
    val coinName: CoinNameDto? = null
)
