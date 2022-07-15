package com.mistersomov.core_data.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CoinInfoDbModel::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun coinInfoDao(): CoinInfoDao

    companion object {
        const val DB_NAME = "astrojet.db"
    }
}