package com.mistersomov.feature_crypto.domain

import com.jakewharton.rxrelay2.BehaviorRelay
import com.mistersomov.feature_crypto.mapper.ICoinInfoMapper
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class CryptoInteractorImpl @Inject constructor(
    private val repository: ICryptoRepository,
    private val coinInfoMapper: ICoinInfoMapper
) : ICryptoInteractor {

    private val cryptoDataRelay = BehaviorRelay.create<List<CoinInfoEntity>>()
    private val cryptoErrorRelay = BehaviorRelay.create<Throwable>()
    private val compositeDisposable = CompositeDisposable()

    override fun fetchData(limit: Int?) {
        compositeDisposable.clear()
        compositeDisposable.add(repository.fetchData(limit)
            .map { list -> list.map { coinInfoMapper.mapDbModelToEntity(it) }
                .sortedBy { it.fromSymbol }}
            .delaySubscription(DELAY, TimeUnit.MILLISECONDS)
            .repeat()
            .retry()
            .subscribeOn(Schedulers.io())
            .subscribe({ cryptoDataRelay.accept(it) }, { cryptoErrorRelay.accept(it) }))
    }

    override fun subscribeToCryptoData(): Observable<List<CoinInfoEntity>> {
        return cryptoDataRelay
    }

    override fun subscribeToCryptoErrors(): Observable<Throwable> {
        return cryptoErrorRelay
    }

    override fun getCoinDetailInfo(): Single<CoinInfoEntity> {
        TODO("Not yet implemented")
    }

    companion object {
        private const val DELAY = 7000L
    }
}