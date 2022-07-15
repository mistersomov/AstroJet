package com.mistersomov.feature_crypto.presentation

import com.mistersomov.core.base.BasePresenter
import com.mistersomov.feature_crypto.domain.CoinInfoEntity
import com.mistersomov.feature_crypto.domain.ICryptoInteractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class CryptoPresenter @Inject constructor(
    private val cryptoInteractor: ICryptoInteractor
) : BasePresenter<CryptoView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        fetchCoinInfoList()
        subscribeToCryptoData()
    }

    private fun fetchCoinInfoList() {
        viewState.showProgressBar(true)
        cryptoInteractor.fetchData(10)
    }

    private fun subscribeToCryptoData() {
        addDisposable(
            cryptoInteractor.subscribeToCryptoData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showCurrentCryptoData(it)
                    viewState.showProgressBar(false)
                }, {

                }
                )
        )
    }

    private fun showCurrentCryptoData(coinList: List<CoinInfoEntity>) {
        viewState.showCoinList(coinList)
    }

}