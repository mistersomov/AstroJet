package com.mistersomov.feature_crypto.presentation

import com.mistersomov.feature_crypto.domain.CoinInfoEntity
import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEnd
import moxy.viewstate.strategy.alias.AddToEndSingle

interface CryptoView : MvpView {

    @AddToEnd
    fun showCoinList(coinInfoEntityList: List<CoinInfoEntity>)

    @AddToEnd
    fun showProgressBar(isVisible: Boolean)

}