package com.example.ecoalpha.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun fromNumber(number: Number?): String? {
        return number?.let { gson.toJson(it) }
    }

    @TypeConverter
    fun toNumber(json: String?): Number? {
        return json?.let {
            val type = object : TypeToken<Number>() {}.type
            gson.fromJson(it, type)
        }
    }

    @TypeConverter
    fun fromCountry(country: Country?): String?{
        return country?.let { gson.toJson(it) }

    }

    @TypeConverter
    fun toCountry(json: String?): Country? {
        return json?.let{
            val type = object : TypeToken<Country>() {}.type
            gson.fromJson(it, type)
        }
    }

    @TypeConverter
    fun fromBank(bank: Bank?): String?{
        return bank?.let { gson.toJson(it) }

    }

    @TypeConverter
    fun toBank(json: String?): Bank? {
        return json?.let{
            val type = object : TypeToken<Bank>() {}.type
            gson.fromJson(it, type)
        }
    }


}