package com.mistersomov.feature_crypto.domain

import com.mistersomov.core_data.database.CoinInfoDbModel
import io.reactivex.Completable
import io.reactivex.Single

interface ICryptoRepository {

    fun fetchData(limit: Int?): Single<List<CoinInfoDbModel>>

    fun getDataFromDatabase(): Single<List<CoinInfoDbModel>>

    fun saveDataToDatabase(list: List<CoinInfoDbModel>): Completable

}