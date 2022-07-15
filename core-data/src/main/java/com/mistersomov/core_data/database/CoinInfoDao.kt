package com.mistersomov.core_data.database


import androidx.room.*
import io.reactivex.Single

@Dao
interface CoinInfoDao {

    @Query("SELECT * FROM currency_info ORDER BY lastUpdate DESC")
    fun getPriceList(): Single<List<CoinInfoDbModel>>

    @Query("SELECT * FROM currency_info WHERE fromSymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin(fSym: String): Single<CoinInfoDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCoinPriceList(currencyList: List<CoinInfoDbModel>)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateCoinPriceList(newList: List<CoinInfoDbModel>)
}