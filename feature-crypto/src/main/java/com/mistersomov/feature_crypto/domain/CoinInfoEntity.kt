package com.mistersomov.feature_crypto.domain

data class CoinInfoEntity(
    val type: String? = null,
    val market: String? = null,
    val fromSymbol: String,
    val toSymbol: String? = null,
    val flags: String? = null,
    val price: Double? = null,
    val lastUpdate: String,
    val median: Double? = null,
    val lastVolume: Double? = null,
    val lastVolumeTo: Double? = null,
    val lastTradeId: String? = null,
    val volumeDay: Double? = null,
    val volumedayto: Double? = null,
    val volume24hour: Double? = null,
    val volume24hourto: Double? = null,
    val openday: Double? = null,
    val highday: Double? = null,
    val lowday: Double? = null,
    val open24hour: Double? = null,
    val high24hour: Double? = null,
    val low24hour: Double? = null,
    val lastMarket: String? = null,
    val volumeHour: Double? = null,
    val volumehourto: Double? = null,
    val openHour: Double? = null,
    val highHour: Double? = null,
    val lowHour: Double? = null,
    val toptiervolume24hour: Double? = null,
    val toptiervolume24hourto: Double? = null,
    val change24hour: Double? = null,
    val changepct24hour: Double? = null,
    val changeday: Int? = null,
    val changepctday: Double? = null,
    val changehour: Double? = null,
    val changepcthour: Double? = null,
    val totalvolume24h: Double? = null,
    val totalvolume24hto: Double? = null,
    val totaltoptiervolume24h: Double? = null,
    val totaltoptiervolume24hto: Double? = null,
    val imageUrl: String,
)