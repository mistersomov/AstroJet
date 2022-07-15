package com.mistersomov.feature_crypto.datasource

import com.mistersomov.core_data.database.CoinInfoDbModel
import io.reactivex.Single

interface ICryptoDatabaseDataSource {

    fun insertCoinPriceList(coinInfoList: List<CoinInfoDbModel>)

    fun getPriceList(): Single<List<CoinInfoDbModel>>

    fun getPriceInfoAboutCoin(fromSymbol: String): Single<CoinInfoDbModel>

    fun updateCoinPriceList(newList: List<CoinInfoDbModel>)
}