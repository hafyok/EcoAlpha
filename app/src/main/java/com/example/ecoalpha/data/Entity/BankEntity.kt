package com.example.ecoalpha.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BankEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String? = null,
    val url: String? = null,
    val phone: String? = null,
    val city: String? = null
)