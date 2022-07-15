package com.mistersomov.feature_crypto.presentation.adapter

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class CryptoViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun update(bundle: Bundle): Boolean? {
        return if (bundle.containsKey(ARG_TREND)) {
            bundle.getBoolean(ARG_TREND)
        } else {
            null
        }
    }

    companion object {
        private const val ARG_TREND = "arg_trend"
    }
}
