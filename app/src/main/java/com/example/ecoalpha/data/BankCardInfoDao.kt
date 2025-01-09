package com.example.ecoalpha.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ecoalpha.data.Entity.BankCardInfoEntity

@Dao
interface BankCardInfoDao {
    @Query("SELECT * FROM BankCardInfoEntity")
    fun getBankInfo(): LiveData<List<BankCardInfoEntity>>

    @Insert
    fun insertBankInfo(bankInfo: BankCardInfoEntity)
}