package com.example.ecoalpha.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ecoalpha.data.Entity.BinCardInfoEntity

@Database(entities = [(BinCardInfoEntity::class)], version = 1)
@TypeConverters(Converters::class)
abstract class AppDB: RoomDatabase() {
    abstract val dao: BinCardInfoDao
}