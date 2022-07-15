package com.mistersomov.core_data.mapper

import com.google.gson.Gson
import com.mistersomov.core_data.database.CoinInfoDbModel
import com.mistersomov.core_data.network.model.crypto.CoinInfoDto
import com.mistersomov.core_data.network.model.crypto.CoinInfoJsonContainerDto
import com.mistersomov.core_data.network.model.crypto.CoinListDto
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CoinMapper @Inject constructor() : ICoinMapper {

    override fun mapDtoToCoinInfoDbModel(dto: CoinInfoDto): CoinInfoDbModel {
        return CoinInfoDbModel(
            fromSymbol = dto.fromSymbol,
            type = dto.type,
            market = dto.market,
            toSymbol = dto.toSymbol,
            flags = dto.flags,
            price = dto.price,
            lastUpdate = dto.lastUpdate,
            median = dto.median,
            lastVolume = dto.lastVolume,
            lastVolumeTo = dto.lastVolumeTo,
            lastTradeId = dto.lastTradeId,
            volumeDay = dto.volumeDay,
            volumedayto = dto.volumedayto,
            volume24hour = dto.volume24hour,
            volume24hourto = dto.volume24hourto,
            openday = dto.openday,
            highday = dto.highday,
            lowday = dto.lowday,
            open24hour = dto.open24hour,
            high24hour = dto.high24hour,
            low24hour = dto.low24hour,
            lastMarket = dto.lastMarket,
            volumeHour = dto.volumeHour,
            volumehourto = dto.volumehourto,
            openHour = dto.openHour,
            highHour = dto.highHour,
            lowHour = dto.lowHour,
            toptiervolume24hour = dto.toptiervolume24hour,
            toptiervolume24hourto = dto.toptiervolume24hourto,
            change24hour = dto.change24hour,
            changepct24hour = dto.changepct24hour,
            changeday = dto.changeday,
            changepctday = dto.changepctday,
            changehour = dto.changehour,
            changepcthour = dto.changepcthour,
            totalvolume24h = dto.totalvolume24h,
            totalvolume24hto = dto.totalvolume24hto,
            totaltoptiervolume24h = dto.totaltoptiervolume24h,
            totaltoptiervolume24hto = dto.totaltoptiervolume24hto,
            imageUrl = BASE_IMAGE_URL + dto.imageUrl
        )
    }

    override fun mapJsonToListCoinInfo(coinInfoJsonContainerDto: CoinInfoJsonContainerDto): List<CoinInfoDto> {
        val result = mutableListOf<CoinInfoDto>()
        val json = coinInfoJsonContainerDto.json ?: return result
        val coinKeySet = json.keySet()
        coinKeySet.forEach { coinKey ->
            val currencyJson = json.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            currencyKeySet.forEach { currencyKey ->
                val priceInfo = Gson().fromJson(
                    currencyJson.getAsJsonObject(currencyKey),
                    CoinInfoDto::class.java
                )
                result.add(priceInfo)
            }
        }
        return result
    }

    override fun mapCoinListDtoToString(coinListDto: CoinListDto): String {
        return coinListDto.names?.map { it.coinName?.name }?.joinToString(",") ?: ""
    }

    companion object {
        private const val BASE_IMAGE_URL = "https://www.cryptocompare.com"
    }
}