package com.example.ecoalpha.data.Entity

import androidx.room.PrimaryKey
import com.example.ecoalpha.data.Bank
import com.example.ecoalpha.data.Country
import com.example.ecoalpha.data.Number

data class BankCardInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val number: Number? = Number(),
    val scheme: String? = null,
    val type: String? = null,
    val brand: String? = null,
    val prepaid: Boolean? = null,
    val country: Country? = Country(),
    val bank: Bank? = Bank()
)
