package com.example.ecoalpha.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ecoalpha.data.Entity.BinCardInfoEntity

@Dao
interface BinCardInfoDao {
    @Query("SELECT * FROM BinCardInfoEntity")
    fun getBankInfo(): LiveData<List<BinCardInfoEntity>>

    @Insert
    fun insertBankInfo(bankInfo: BinCardInfoEntity)
}