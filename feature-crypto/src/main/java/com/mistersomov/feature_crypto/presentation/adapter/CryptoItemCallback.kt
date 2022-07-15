package com.mistersomov.feature_crypto.presentation.adapter

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil
import com.mistersomov.feature_crypto.domain.CoinInfoEntity

class CryptoItemCallback : DiffUtil.ItemCallback<CoinInfoEntity>() {
    override fun areItemsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem.fromSymbol == newItem.fromSymbol
    }

    override fun areContentsTheSame(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: CoinInfoEntity, newItem: CoinInfoEntity): Any? {
        if (oldItem.fromSymbol == newItem.fromSymbol) {
            return if (oldItem.price == newItem.price) {
                return super.getChangePayload(oldItem, newItem)
            } else {
                val bundle = Bundle()
                if (newItem.price!! > oldItem.price!!) {
                    bundle.putBoolean(ARG_TREND, true)
                } else {
                    bundle.putBoolean(ARG_TREND, false)
                }
                bundle
            }
        }
        return super.getChangePayload(oldItem, newItem)
    }

    companion object {
        private const val ARG_TREND = "arg_trend"
    }
}