package com.mistersomov.core_data.di

import com.mistersomov.core_data.mapper.CoinMapper
import com.mistersomov.core_data.mapper.ICoinMapper
import com.mistersomov.core_data.repository.CryptoWebRepositoryImpl
import com.mistersomov.core_data.repository.ICryptoWebRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface DataModule {

    @Binds
    @Singleton
    fun bindWebService(webServiceImpl: CryptoWebRepositoryImpl): ICryptoWebRepository

    @Binds
    @Singleton
    fun bindCoinMapper(coinMapper: CoinMapper): ICoinMapper
}