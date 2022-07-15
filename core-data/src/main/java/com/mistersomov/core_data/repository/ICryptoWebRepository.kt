package com.mistersomov.core_data.repository

import com.mistersomov.core_data.database.CoinInfoDbModel
import io.reactivex.Single

interface ICryptoWebRepository {

    fun fetchData(limit: Int?): Single<List<CoinInfoDbModel>>
}