package com.mistersomov.feature_crypto.datasource

import com.mistersomov.core_data.database.CoinInfoDbModel
import com.mistersomov.core_data.repository.ICryptoWebRepository
import io.reactivex.Single
import javax.inject.Inject

class CryptoRemoteDataSource @Inject constructor(
    private val webService: ICryptoWebRepository
) : ICryptoRemoteDataSource {

    override fun fetchData(limit: Int?): Single<List<CoinInfoDbModel>> {
        return webService.fetchData(limit)
    }
}