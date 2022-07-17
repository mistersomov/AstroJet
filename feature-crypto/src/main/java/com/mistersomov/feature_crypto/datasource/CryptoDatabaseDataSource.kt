package com.mistersomov.feature_crypto.datasource

import com.mistersomov.core_data.database.AppDatabase
import com.mistersomov.core_data.database.CoinInfoDbModel
import io.reactivex.Single
import javax.inject.Inject

class CryptoDatabaseDataSource @Inject constructor(
    private val appDatabase: AppDatabase
) : ICryptoDatabaseDataSource {

    override fun insertCoinPriceList(coinInfoList: List<CoinInfoDbModel>) {
        appDatabase.coinInfoDao().insertCoinPriceList(coinInfoList)
    }

    override fun getPriceList(): Single<List<CoinInfoDbModel>> {
        return appDatabase.coinInfoDao().getPriceList()
    }

    override fun getPriceInfoAboutCoin(fromSymbol: String): Single<CoinInfoDbModel> {
        return appDatabase.coinInfoDao().getPriceInfoAboutCoin(fSym = fromSymbol)
    }

    override fun updateCoinPriceList(newList: List<CoinInfoDbModel>) {
        appDatabase.coinInfoDao().updateCoinPriceList(newList)
    }
}