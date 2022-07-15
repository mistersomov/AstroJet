package com.mistersomov.feature_crypto.domain

import io.reactivex.Observable
import io.reactivex.Single

interface ICryptoInteractor {

    fun fetchData(limit: Int?)

    fun subscribeToCryptoData(): Observable<List<CoinInfoEntity>>

    fun subscribeToCryptoErrors(): Observable<Throwable>

    fun getCoinDetailInfo(): Single<CoinInfoEntity>

}