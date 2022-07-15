package com.mistersomov.core_data.network.api

import com.mistersomov.core_data.network.model.crypto.CoinInfoJsonContainerDto
import com.mistersomov.core_data.network.model.crypto.CoinListDto
import io.reactivex.Single

import retrofit2.http.GET
import retrofit2.http.Query

interface IApiService {

    @GET("top/totalvolfull")
    fun getTopCoinInfoList(
        @Query(QUERY_PARAM_API_KEY) api_key: String? = DEFAULT_API_KEY,
        @Query(QUERY_PARAM_LIMIT) limit: Int? = DEFAULT_LIMIT,
        @Query(QUERY_PARAM_TO_SYMBOL) tSym: String? = CURRENCY
    ): Single<CoinListDto>

    @GET("pricemultifull")
    fun getPriceList(
        @Query(QUERY_PARAM_API_KEY) api_key: String? = DEFAULT_API_KEY,
        @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) tSyms: String? = CURRENCY
    ): Single<CoinInfoJsonContainerDto>

    companion object {
        private const val QUERY_PARAM_API_KEY = "api_key"
        private const val QUERY_PARAM_LIMIT = "limit"
        private const val QUERY_PARAM_TO_SYMBOL = "tsym"
        private const val QUERY_PARAM_TO_SYMBOLS = "tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS = "fsyms"
        private const val DEFAULT_API_KEY =
            "3ef0acf008a4882c1a80ff19d366b02d633560fec23efb9292c4726ac218314e"
        private const val DEFAULT_LIMIT = 10
        private const val CURRENCY = "USD"
    }
}