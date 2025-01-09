package com.example.ecoalpha.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CountryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val numeric: String? = null,
    val alpha2: String? = null,
    val name: String? = null,
    val emoji: String? = null,
    val currency: String? = null,
    val latitude: Int? = null,
    val longitude: Int? = null
)
