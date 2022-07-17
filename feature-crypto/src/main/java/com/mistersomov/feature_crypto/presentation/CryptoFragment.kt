package com.mistersomov.feature_crypto.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import com.mistersomov.core.base.BaseFragment
import com.mistersomov.feature_crypto.R
import com.mistersomov.feature_crypto.databinding.CryptoFragmentBinding
import com.mistersomov.feature_crypto.di.FeatureCryptoComponentProvider
import com.mistersomov.feature_crypto.domain.CoinInfoEntity
import com.mistersomov.feature_crypto.presentation.adapter.CryptoAdapter
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class CryptoFragment : BaseFragment(), CryptoView {

    @InjectPresenter
    lateinit var presenter: CryptoPresenter

    @Inject
    lateinit var presenterProvider: Provider<CryptoPresenter>

    @ProvidePresenter
    fun providePresenter(): CryptoPresenter {
        return presenterProvider.get()
    }

    private var _binding: CryptoFragmentBinding? = null
    private val binding: CryptoFragmentBinding
        get() = _binding ?: throw RuntimeException("Error")
    private lateinit var cryptoAdapter: CryptoAdapter


    override fun injectComponent() {
        (requireContext().applicationContext as FeatureCryptoComponentProvider)
            .provideFeatureCryptoComponent()
            .inject(this)
    }

    override fun destroyComponent() {
        (requireContext().applicationContext as FeatureCryptoComponentProvider).destroyComponent()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = CryptoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    override fun showCoinList(coinInfoEntityList: List<CoinInfoEntity>) {
        cryptoAdapter.submitList(coinInfoEntityList)
    }

    override fun showProgressBar(isVisible: Boolean) {
        binding.cryptoProgressBar.isVisible = isVisible
    }

    private fun setupRecyclerView() {
        val recyclerView: RecyclerView = binding.cryptoRecyclerView
        cryptoAdapter = CryptoAdapter()
        recyclerView.apply {
            adapter = cryptoAdapter
            itemAnimator = null
        }
        cryptoAdapter.onCryptoItemClick = {  }
    }

    companion object {
        private const val TOOLBAR_TITLE = "Trading"
    }
}