package com.mistersomov.feature_crypto.repository

import com.mistersomov.core_data.database.CoinInfoDbModel
import com.mistersomov.feature_crypto.datasource.ICryptoDatabaseDataSource
import com.mistersomov.feature_crypto.datasource.ICryptoRemoteDataSource
import com.mistersomov.feature_crypto.domain.ICryptoRepository
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

class CryptoRepositoryImpl @Inject constructor(
    private val cryptoDatabaseDataSource: ICryptoDatabaseDataSource,
    private val cryptoRemoteDataSource: ICryptoRemoteDataSource,
) : ICryptoRepository {

    override fun fetchData(limit: Int?): Single<List<CoinInfoDbModel>> {
        return cryptoRemoteDataSource.fetchData(limit)
            .flatMapCompletable { saveDataToDatabase(it) }
            .andThen(getDataFromDatabase())
    }

    override fun getDataFromDatabase(): Single<List<CoinInfoDbModel>> {
        return cryptoDatabaseDataSource.getPriceList()
    }

    override fun saveDataToDatabase(list: List<CoinInfoDbModel>): Completable {
        return try {
            Completable.fromAction {
                cryptoDatabaseDataSource.insertCoinPriceList(list)
            }
        } catch (ex: Exception) {
            Completable.error(ex)
        }
    }
}