package com.mistersomov.core_data.repository

import com.mistersomov.core_data.database.CoinInfoDbModel
import com.mistersomov.core_data.mapper.ICoinMapper
import com.mistersomov.core_data.network.api.ApiFactory
import io.reactivex.Single
import javax.inject.Inject

class CryptoWebRepositoryImpl @Inject constructor(
    private val coinMapper: ICoinMapper
) : ICryptoWebRepository {

    private val apiService = ApiFactory.apiService

    override fun fetchData(limit: Int?): Single<List<CoinInfoDbModel>> {
        return apiService.getTopCoinInfoList(limit = limit)
            .map { list -> coinMapper.mapCoinListDtoToString(list) }
            .flatMap { raw -> apiService.getPriceList(fSyms = raw) }
            .map { container ->
                coinMapper.mapJsonToListCoinInfo(container)
                    .map { coinMapper.mapDtoToCoinInfoDbModel(it) }
            }
    }
}