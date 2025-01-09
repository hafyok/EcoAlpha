package com.example.ecoalpha.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ecoalpha.data.Entity.BankCardInfoEntity

@Database(entities = [(BankCardInfoEntity::class)], version = 1)
abstract class AppDB: RoomDatabase() {
    abstract val dao: BankCardInfoDao
}