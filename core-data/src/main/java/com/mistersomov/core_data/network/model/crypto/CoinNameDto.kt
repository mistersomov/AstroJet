package com.mistersomov.core_data.network.model.crypto

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

data class CoinNameDto(
    @SerializedName("Id")
    @Expose
    val id: String? = null,
    @SerializedName("Name")
    @Expose
    val name: String? = null,
    @SerializedName("FullName")
    @Expose
    val fullName: String? = null
)
