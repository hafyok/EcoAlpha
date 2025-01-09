package com.example.ecoalpha.data.Entity

import androidx.room.PrimaryKey

data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val length: Int? = null,
    val luhn: Boolean? = null
)
