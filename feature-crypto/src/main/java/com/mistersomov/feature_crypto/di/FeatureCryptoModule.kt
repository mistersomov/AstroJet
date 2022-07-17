package com.mistersomov.feature_crypto.di

import com.mistersomov.feature_crypto.repository.CryptoRepositoryImpl
import com.mistersomov.feature_crypto.datasource.CryptoDatabaseDataSource
import com.mistersomov.feature_crypto.datasource.CryptoRemoteDataSource
import com.mistersomov.feature_crypto.datasource.ICryptoDatabaseDataSource
import com.mistersomov.feature_crypto.datasource.ICryptoRemoteDataSource
import com.mistersomov.feature_crypto.domain.CryptoInteractorImpl
import com.mistersomov.feature_crypto.domain.ICryptoInteractor
import com.mistersomov.feature_crypto.domain.ICryptoRepository
import com.mistersomov.feature_crypto.mapper.CoinInfoMapper
import com.mistersomov.feature_crypto.mapper.ICoinInfoMapper
import dagger.Binds
import dagger.Module

@Module
interface FeatureCryptoModule {

    @CryptoScope
    @Binds
    fun bindCryptoInteractor(impl: CryptoInteractorImpl): ICryptoInteractor

    @CryptoScope
    @Binds
    fun bindCryptoRepsitory(impl: CryptoRepositoryImpl): ICryptoRepository

    @CryptoScope
    @Binds
    fun bindCryptoDatabaseDataSource(impl: CryptoDatabaseDataSource): ICryptoDatabaseDataSource

    @CryptoScope
    @Binds
    fun bindCryptoRemoteDataSource(impl: CryptoRemoteDataSource): ICryptoRemoteDataSource

    @CryptoScope
    @Binds
    fun bindCoinInfoMapper(impl: CoinInfoMapper): ICoinInfoMapper
}