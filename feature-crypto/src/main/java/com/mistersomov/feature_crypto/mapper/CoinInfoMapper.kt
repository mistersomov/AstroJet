package com.mistersomov.feature_crypto.mapper

import com.mistersomov.core_data.database.CoinInfoDbModel
import com.mistersomov.feature_crypto.domain.CoinInfoEntity
import java.sql.Date
import java.sql.Timestamp
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class CoinInfoMapper @Inject constructor() : ICoinInfoMapper {

    override fun mapDbModelToEntity(dbModel: CoinInfoDbModel): CoinInfoEntity {
        return CoinInfoEntity(
            fromSymbol = dbModel.fromSymbol,
            type = dbModel.type,
            market = dbModel.market,
            toSymbol = dbModel.toSymbol,
            flags = dbModel.flags,
            price = dbModel.price,
            lastUpdate = convertTime(dbModel.lastUpdate),
            median = dbModel.median,
            lastVolume = dbModel.lastVolume,
            lastVolumeTo = dbModel.lastVolumeTo,
            lastTradeId = dbModel.lastTradeId,
            volumeDay = dbModel.volumeDay,
            volumedayto = dbModel.volumedayto,
            volume24hour = dbModel.volume24hour,
            volume24hourto = dbModel.volume24hourto,
            openday = dbModel.openday,
            highday = dbModel.highday,
            lowday = dbModel.lowday,
            open24hour = dbModel.open24hour,
            high24hour = dbModel.high24hour,
            low24hour = dbModel.low24hour,
            lastMarket = dbModel.lastMarket,
            volumeHour = dbModel.volumeHour,
            volumehourto = dbModel.volumehourto,
            openHour = dbModel.openHour,
            highHour = dbModel.highHour,
            lowHour = dbModel.lowHour,
            toptiervolume24hour = dbModel.toptiervolume24hour,
            toptiervolume24hourto = dbModel.toptiervolume24hourto,
            change24hour = dbModel.change24hour,
            changepct24hour = dbModel.changepct24hour,
            changeday = dbModel.changeday,
            changepctday = dbModel.changepctday,
            changehour = dbModel.changehour,
            changepcthour = dbModel.changepcthour,
            totalvolume24h = dbModel.totalvolume24h,
            totalvolume24hto = dbModel.totalvolume24hto,
            totaltoptiervolume24h = dbModel.totaltoptiervolume24h,
            totaltoptiervolume24hto = dbModel.totaltoptiervolume24hto,
            imageUrl = dbModel.imageUrl
        )
    }

    override fun convertTime(timeStamp: Long?): String {
        if (timeStamp == null) return ""
        val stamp = Timestamp(timeStamp * 1000)
        val date = Date(stamp.time)
        val pattern = "HH:mm:ss"
        val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
        simpleDateFormat.timeZone = TimeZone.getDefault()
        return simpleDateFormat.format(date)
    }

    override fun formatCurrency(currency: Double?): String {
        if (currency == null) return ""
        val pattern = if (currency <= MIN_VALUE) SEVEN_DECIMAL else THREE_DECIMAL
        val formatter = DecimalFormat(pattern)
        return formatter.format(currency)
    }

    companion object {
        private const val MIN_VALUE = 1E-4
        private const val SEVEN_DECIMAL = "0.0000000"
        private const val THREE_DECIMAL = "0.000"
    }
}