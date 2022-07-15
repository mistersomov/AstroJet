package com.mistersomov.feature_crypto.presentation.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.mistersomov.feature_crypto.R
import com.mistersomov.feature_crypto.databinding.CryptoItemBinding
import com.mistersomov.feature_crypto.domain.CoinInfoEntity
import com.squareup.picasso.Picasso

class CryptoAdapter : ListAdapter<CoinInfoEntity, CryptoViewHolder>(CryptoItemCallback()) {

    var onCryptoItemClick: ((CoinInfoEntity) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoViewHolder {
        val layout =
            if (viewType == VIEW_TYPE_ENABLED) R.layout.crypto_item else throw RuntimeException("Invalid viewtype")
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),
            layout,
            parent,
            false
        )
        return CryptoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CryptoViewHolder, position: Int) {
        onBindViewHolder(holder, position, emptyList<Any>().toMutableList())
    }

    override fun onBindViewHolder(
        holder: CryptoViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        val cryptoItem = getItem(position)
        val context: Context = holder.itemView.context
        when (val binding = holder.binding) {
            is CryptoItemBinding -> {
                holder.itemView.setOnClickListener { onCryptoItemClick?.invoke(cryptoItem) }

                with(binding) {
                    with(cryptoItem) {
                        Picasso.get().load(imageUrl).into(cryptoIcon)
                        cryptoTicker.text = fromSymbol
                        cryptoFullName.text = type
                        cryptoCurrency.text = price?.toString()
                        cryptoLastUpdate.text = String.format(
                            root.context.getString(R.string.crypto_last_update),
                            lastUpdate
                        )
                        trend.isVisible = false
                        if (payloads.isNotEmpty() && payloads.first() is Bundle) {
                            payloads.first()
                            val isHigher = holder.update(payloads.first() as Bundle)
                            val drawable: Drawable
                            if (isHigher != null) {
                                drawable = if (isHigher) {
                                    AppCompatResources.getDrawable(context, R.drawable.ic_triangle_up)!!
                                } else {
                                    AppCompatResources.getDrawable(context, R.drawable.ic_triangle_down)!!
                                }
                                trend.apply {
                                    setImageDrawable(drawable)
                                    isVisible = true
                                    startAnimation(AnimationUtils.loadAnimation(context, R.anim.test))
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val cryptoItem = getItem(position)

        return if (true) VIEW_TYPE_ENABLED else VIEW_TYPE_DISABLED
    }

    companion object {
        private const val VIEW_TYPE_ENABLED = 0
        private const val VIEW_TYPE_DISABLED = 1

    }
}