package com.mistersomov.feature_crypto.datasource

import com.mistersomov.core_data.database.CoinInfoDbModel
import io.reactivex.Single

interface ICryptoRemoteDataSource {

    fun fetchData(limit: Int?): Single<List<CoinInfoDbModel>>
}