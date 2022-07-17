package com.mistersomov.feature_crypto.mapper

import com.mistersomov.core_data.database.CoinInfoDbModel
import com.mistersomov.feature_crypto.domain.CoinInfoEntity

interface ICoinInfoMapper {

    fun mapDbModelToEntity(dbModel: CoinInfoDbModel): CoinInfoEntity

    fun convertTime(timeStamp: Long?): String

    fun formatCurrency(currency: Double?): String
}